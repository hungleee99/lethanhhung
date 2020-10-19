

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

    // khi load dữ liệu song thì tìm kiếm theo tên
    $(function(){
        $("#myInput").on("keyup", function() {
          var value = $(this).val().toLowerCase();
          $("#myTable tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
          });
        });
    });
}
var employees = [];
var counter =0;

// ham khoi tao 
function Employee(name,department,phone){
    this.id = ++counter;
    this.name = name;
    this.department = department;
    this.phone = phone;
}

// truyền vào dữ liệu (database)
function initEmployees(){
    if(null== employees || employees.length==0){
        employees.push(new Employee("John Doe","DEV","0312456789"));
        employees.push(new Employee("John Witch","Manager","0312452555"));
        employees.push(new Employee("Van Gan","Employee","9552620555"));
    }
}

function buildtable(){
    
    setTimeout(function name(params){
        // xoa ban ghi truoc khi cap nhap
        $('tbody').empty();
        // chuyen du lieu vao
        initEmployees();
        employees.forEach(function(item){
            $('tbody').append(
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
function addEmployee(){
    //ko tao id

    // Type DOM
    // var name = document.getElementById("name").value;
    // var department = document.getElementById("department").value;
    // var phone = document.getElementById("phone").value;

    // Type JQuery
    var name = $("#name").val();
    var department = $("#department").val();
    var phone = $("#phone").val();
    // add du lieu sau khi nhap
    employees.push(new Employee(name,department,phone));
    // dong modal
    hideModal();
    showSuccessAlert();
    buildtable(); 
}
function resetform(){
    // DOM --->
    // document.getElementById("id").value="";
    // document.getElementById("name").value="";
    // document.getElementById("department").value="";
    // document.getElementById("phone").value="";

    // JQuery --->
    $("#id").val("");
    $("#name").val("");
    $("#department").val("");
    $("#phone").val("");
}

function openUpdateModal(id){
    $('#modal-title').text("Update Employee");
    //get id
    var index = employees.findIndex(x => x.id == id);

    // fill data
    // tao thuoc tinh id de update va KO tao o add

    //  Type DOM
    // document.getElementById("id").value=employees[index].id;
    // document.getElementById("name").value=employees[index].name;
    // document.getElementById("department").value=employees[index].department;
    // document.getElementById("phone").value=employees[index].phone;

    // Type JQuery
    $("#id").val(employees[index].id);
    $("#name").val(employees[index].name);
    $("#department").val(employees[index].department);
    $("#phone").val(employees[index].phone);
    openModal();
}
function save(){
    var id = document.getElementById("id").value;
    if(id== null || id == ""){
        addEmployee();
    }else{
        updateEmloyee();
    }
}
function updateEmloyee(){
    // test
    console.log("oki");

    // get list

    // Type DOM
    // var id =  document.getElementById("id").value;
    // var name = document.getElementById("name").value;
    // var department = document.getElementById("department").value;
    // var phone = document.getElementById("phone").value;

    // Type JQuery
    var id =  $("#id").val();
    var name = $("#name").val();
    var department = $("#department").val();
    var phone = $("#phone").val();

    var index = employees.findIndex(x => x.id == id);
    console.log(index);
    // add du lieu sau khi nhap

    //update employee
    employees[index].name =name;
    employees[index].department =department;
    employees[index].phone =phone;

    // dong modal
    hideModal();
    showSuccessAlert();
    buildtable(); 
}
function showSuccessAlert(){
    $('#success-alert').fadeTo(2000,500).slideUp(500,function(){
        $('#success-alert').slideUp(500);
    });
}

function openConfirmDelete(id){
    var index = employees.findIndex(x => x.id == id);
    var name =employees[index].name;
    var result = confirm("Want to delete "+ name +" ?");
    if (result) {
        //Logic to delete the item
        deleteEmployee(id);
    }
}
function deleteEmployee(id){
    var index = employees.findIndex(x => x.id == id);
    employees.splice(index,1);
    showSuccessAlert();
    buildtable(); 
}

