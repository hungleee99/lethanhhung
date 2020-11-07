

$(document).ready(function () {
    $(".header").load("header.html");
    $(".main").load("myhome.html");
    $(".footer").load("footer.html");

});
function navhome() {
    $(".main").load("myhome.html");
}
function manager() {
    $(".main").load("viewList.html");
    buildtable();

}
var employees = [];

// ham khoi tao 
function Employee(id, name) {
    this.id = id;
    this.name = name;
}

// lấy dữ liệu (database)
function getListEmployees() {
    $.get("http://localhost:8080/api/v1/departments", function (data, status) {

        // reset list employees
        employees = [];

        // error
        if (status == "error") {
            // TODO
            alert("Error when loading data");
            return;
        }

        // success
        parseData(data);
        fillEmployeeToTable();
    });
}

function parseData(data) {
    employees = data;
}

function fillEmployeeToTable() {
    search();
    employees.forEach(function (item) {
        $('#myTable').append(
            '<tr>' +
            '<td>' + item.name + '</td>' +
            '<td>' +
            '<a class="edit" title="Edit" data-toggle="tooltip" onclick="openUpdateModal(' + item.id + ')"><i class="material-icons">&#xE254;</i></a>' +
            '<a class="delete" title="Delete" data-toggle="tooltip" onclick="openConfirmDelete(' + item.id + ')"><i class="material-icons">&#xE872;</i></a>' +
            '</td>' +
            '</tr>')
    });
}

function buildtable() {
    // xoa ban ghi truoc khi cap nhap
    $('tbody').empty();
    
    // khi load dữ liệu song thì tìm kiếm theo tên
    
    getListEmployees();
    
}
function openAddModal() {
    // document.getElementById('modal-title').innerHTML = "ADD Employee";
    $('#modal-title').text("ADD Employee");

    resetform();
    openModal();

}
function openModal() {
    $('#myModal').modal('show');
}
function hideModal() {
    $('#myModal').modal('hide');
}

// add employee
function addEmployee() {
    //ko tao id
    var name = $("#name").val();

    // add du lieu sau khi nhap
    var employee = {
        name: name
    };
    $.ajax({
        url: 'http://localhost:8080/api/v1/departments',
        type: 'POST',
        data: JSON.stringify(employee), // body
        contentType: "application/json", // type of body (json, xml, text)
        // dataType: 'json', // datatype return
        success: function (data, textStatus, xhr) {
            hideModal();
            showSuccessAlert();
            buildtable();
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}

// reset form
function resetform() {
    $("#id").val("");
    $("#name").val("");
    $("#department").val("");
    $("#phone").val("");
}

// update employee
function openUpdateModal(id) {

    $('#modal-title').text("Update Employee");
    //get id

    var index = employees.findIndex(x => x.id == id);
    // fill data
    $("#id").val(employees[index].id);
    $("#name").val(employees[index].name);
    openModal();
}

// save in modal
function save() {
    var id = document.getElementById("id").value;
    if (id == null || id == "") {
        addEmployee();
    } else {
        updateEmloyee();
    }
}

// action update
function updateEmloyee() {
    var id = $("#id").val();
    var name = $("#name").val();
    var employee = {
        name: name
    };
    $.ajax({
        url: 'http://localhost:8080/api/v1/departments/' + id,
        type: 'PUT',
        data: JSON.stringify(employee),
        contentType: "application/json",
        success: function (result) {
            // success
            hideModal();
            showSuccessAlert();
            buildtable();
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}
function showSuccessAlert() {
    $('#success-alert').fadeTo(2000, 500).slideUp(500, function () {
        $('#success-alert').slideUp(500);
    });
}

function openConfirmDelete(id) {

    // get index from employee's id
    var index = employees.findIndex(x => x.id == id);
    var name = employees[index].name;

    var result = confirm("Want to delete " + name + "?");
    if (result) {
        resetform();
        deleteEmployee(id);
    }
}

function deleteEmployee(id) {
    // TODO validate

    $.ajax({
        url: 'http://localhost:8080/api/v1/departments/' + id,
        type: 'DELETE',
        success: function (result) {
            // success
            showSuccessAlert();
            buildtable();
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}
function search() {
    $(function () {
        $("#myInput").on("keyup", function () {
            var value = $(this).val().toLowerCase();
            $("#myTable tr").filter(function () {
                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)             
            });
        });
    });
}

function search_hibernate() {
    resetform();
    hibernate(search);
}
function hibernate(search) {
    var search = $("#search").val();
    $.get("http://localhost:8080/api/v1/departments?search="+ search, function (data, status) {
        $('tbody').empty();
        parseData(data);
        fillEmployeeToTable();
    });
}


var page=1,
    size=5,
    totalrecord=15;
function prepage(){
    if(page>1){
        page--;
        resetform();
        pageP();
    }
    console.log(page);
}
function nextpage(){
    if(page*size <totalrecord){
        page++;
        resetform();
        pageP();
    }
    console.log(page);
}
function pageP(){
    
    $.get("http://localhost:8080/api/v1/departments?page="+ page, function (data, status) {
        $('tbody').empty();
        parseData(data);
        fillEmployeeToTable();
    });
}
