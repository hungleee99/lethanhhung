

$(document).ready(function(){
    $(".header").load("header.html"); 
    $(".main").load("myhome.html");
    $(".footer").load("footer.html");

});
function navhome(){
    $(".main").load("myhome.html");
}
function manager(){
    $(".main").load("viewList.html");
    buildtable();

}
var employees = [];

// ham khoi tao 
function Employee(id,name,department,phone){
    this.id = id;
    this.name = name;
    this.department = department;
    this.phone = phone;
}

// lấy dữ liệu (database)
function getListEmployees(){
    $.get("https://5f8d9c574c15c40016a1df4c.mockapi.io/students",function(data,status){
        employees = [];
        if(status =="error"){
            alert("loi laoding data")
            return;
        }
        parseData(data);
        fillEmployeeToTable();
    });
}

function parseData(data) {
    data.forEach(function(item) {
        employees.push(new Employee(item.id, item.name, item.department, item.phone));
    });
}

function fillEmployeeToTable(){
		search();
        employees.forEach(function(item){
            $('#myTable').append(
                '<tr>'+ 
                    '<td>'+item.name+'</td>'+
                    '<td>'+item.department+'</td>'+
                    '<td>'+item.phone+'</td>'+
                    '<td>'+
                        '<a class="edit" title="Edit" data-toggle="tooltip" onclick="openUpdateModal('+item.id+')"><i class="material-icons">&#xE254;</i></a>'+
                        '<a class="delete" title="Delete" data-toggle="tooltip" onclick="openConfirmDelete('+item.id+')"><i class="material-icons">&#xE872;</i></a>'+
                    '</td>'+
                '</tr>')
          });
}

function buildtable(){
    setTimeout(function name(params){
        // xoa ban ghi truoc khi cap nhap
        $('tbody').empty();
        
        // khi load dữ liệu song thì tìm kiếm theo tên
        
        getListEmployees();
    },500);
}
function openAddModal(){
    // document.getElementById('modal-title').innerHTML = "ADD Employee";
    $('#modal-title').text("ADD Employee");

    resetform();
    openModal();

}
function openModal(){
    $('#myModal').modal('show');
}
function hideModal(){
    $('#myModal').modal('hide');
}

// add employee
function addEmployee(){
    //ko tao id
    var name = $("#name").val();
    var department = $("#department").val();
    var phone = $("#phone").val();
    // add du lieu sau khi nhap
    var employee ={
        name:name,
        department:department,
        phone:phone
    };
    $.post("https://5f8d9c574c15c40016a1df4c.mockapi.io/students", employee,
    function(data, status) {
        // error
        if (status == "error") {
            alert("Error when loading data");
            return;
        }
    // dong modal
        hideModal();
        showSuccessAlert();
        buildtable(); 
    });
}

// reset form
function resetform(){
    $("#id").val("");
    $("#name").val("");
    $("#department").val("");
    $("#phone").val("");
}

// update employee
function openUpdateModal(id){
    
    $('#modal-title').text("Update Employee");
    //get id

    var index = employees.findIndex(x => x.id == id);
    // fill data
    $("#id").val(employees[index].id);
    $("#name").val(employees[index].name);
    $("#department").val(employees[index].department);
    $("#phone").val(employees[index].phone);
    openModal();

}

// save in modal
function save(){
    var id = document.getElementById("id").value;
    if(id== null || id == ""){
        addEmployee();
    }else{
        updateEmloyee();
    }
}

// action update
function updateEmloyee(){
    var id =  $("#id").val();
    var name = $("#name").val();
    var department = $("#department").val();
    var phone = $("#phone").val();
    var employee ={
        name:name,
        department:department,
        phone:phone
    };
    $.ajax({
        url: 'https://5f8d9c574c15c40016a1df4c.mockapi.io/students/' + id,
        type: 'PUT',
        data: employee,
        success: function(result) {
            // error
            if (result == undefined || result == null) {
                alert("Error when loading data");
                return;
            }

            // success
            hideModal();
            showSuccessAlert();
            buildtable(); 
            
        }
    });
}
function showSuccessAlert(){
    $('#success-alert').fadeTo(2000,500).slideUp(500,function(){
        $('#success-alert').slideUp(500);
    });
}

function openConfirmDelete(id) {
    
    // get index from employee's id
    var index = employees.findIndex(x => x.id == id);
    var name = employees[index].name;

    var result = confirm("Want to delete " + name + "?");
    if (result) {
        deleteEmployee(id);
    }
}

function deleteEmployee(id) {
    // TODO validate

    $.ajax({
        url: 'https://5f8d9c574c15c40016a1df4c.mockapi.io/students/' + id,
        type: 'DELETE',
        success: function(result) {
            // error
            if (result == undefined || result == null) {
                alert("Error when loading data");
                return;
            }

            // success
            showSuccessAlert();
            buildtable(); 
        }

    });
}
function search(){
    $(function(){
        $("#myInput").on("keyup", function() {
            var value = $(this).val().toLowerCase();
            $("#myTable tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
            });
        });
    });
}