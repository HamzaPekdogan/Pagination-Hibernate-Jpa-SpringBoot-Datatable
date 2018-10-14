var studentTable;
var studentClassTable;
var studentInClassTable;
$('document').ready(function () {
    studentTable = $('.studentTable').DataTable({
        responsive: true,
        serverSide: true,
        ajax: "/studentAjax",
        "language": {
            "info": "_START_-_END_ of _TOTAL_ entries",
            searchPlaceholder: "Search"
        },
        dom: 'Bfrtip',
        buttons: [
            'copy', 'csv', 'pdf', 'print'
        ]
    });
    studentClassTable = $('.studentClassTable').DataTable({
        responsive: true,
        serverSide: true,
        ajax: "/studentClassAjax",
        "language": {
            "info": "_START_-_END_ of _TOTAL_ entries",
            searchPlaceholder: "Search"
        },
        dom: 'Bfrtip',
        buttons: [
            'copy', 'csv', 'pdf', 'print'
        ]
    });
    studentInClassTable = $('.studentInClassTable').DataTable({
        responsive: true,
        serverSide: true,
        ajax: "/studentInClassAjax",
        "language": {
            "info": "_START_-_END_ of _TOTAL_ entries",
            searchPlaceholder: "Search"
        },
        dom: 'Bfrtip',
        buttons: [
            'copy', 'csv', 'pdf', 'print'
        ]
    });
    studentList();
    studentClassList();
});

function closeModalStudent() {
    $(".studentModel").hide(500);
    $(".studentModel").addClass("fade");
}

function openModelStudent() {
    $(".studentModel").show(500);
    $(".studentModel").removeClass("fade");
}

function closeModalStudentClass() {
    $(".studentClassModel").hide(500);
    $(".studentClassModel").addClass("fade");
}

function openModelStudentClass() {
    $(".studentClassModel").show(500);
    $(".studentClassModel").removeClass("fade");
}

function saveStudent() {
    var oMyForm = new FormData();
    oMyForm.append("name", $("#studentname").val());
    $.ajax({
        url: 'saveStudent',
        method: 'post',
        processData: false,
        contentType: false,
        cache: false,
        data: oMyForm,
        dataType: 'text',
        success: function (response) {
            closeModalStudent();
            studentTable.clear().draw();
            studentList();
            $("#studentname").val("");
        }, error: function () {
            console.log("not okay");
        }
    });
}

function saveStudentClass() {
    var oMyForm = new FormData();
    oMyForm.append("name", $("#studentclassname").val());
    $.ajax({
        url: 'saveStudentClass',
        method: 'post',
        processData: false,
        contentType: false,
        cache: false,
        data: oMyForm,
        dataType: 'text',
        success: function (response) {
            closeModalStudentClass();
            studentClassTable.clear().draw();
            studentClassList();
            $("#studentclassname").val("");
        }, error: function () {
            console.log("not okay");
        }
    });
}

function saveStudentInClass() {
    var oMyForm = new FormData();
    oMyForm.append("studentUuid", $("#studentList").val());
    oMyForm.append("studentClassUuid", $("#studentClassList").val());
    $.ajax({
        url: 'saveStudentInClass',
        method: 'post',
        processData: false,
        contentType: false,
        cache: false,
        data: oMyForm,
        dataType: 'text',
        success: function (response) {
            studentInClassTable.clear().draw();
            Alert("Kayıt Başarılı.");
        }, error: function () {
            console.log("not okay");
        }
    });
}

function studentList() {
    $.ajax({
        url: 'studentList',
        method: 'get',
        processData: false,
        contentType: false,
        cache: false,
        success: function (response) {
            select = document.getElementById("studentList");
            var i;
            for(i = select.options.length - 1 ; i >= 0 ; i--)
            {
                select.remove(i);
            }
            response.forEach(function (value, key, map) {
                option = document.createElement('option');
                option.value = value.id;
                option.text = value.name;
                select.add(option);
            })
        }, error: function () {
            console.log("not okay");
        }
    });
}

function studentClassList() {
    $.ajax({
        url: 'studentClassList',
        method: 'get',
        processData: false,
        contentType: false,
        cache: false,
        success: function (response) {
            select = document.getElementById("studentClassList");
            var i;
            for(i = select.options.length - 1 ; i >= 0 ; i--)
            {
                select.remove(i);
            }
            response.forEach(function (value, key, map) {
                option = document.createElement('option');
                option.value = value.id;
                option.text = value.name;
                select.add(option);
            })
        }, error: function () {
            console.log("not okay");
        }
    });
}