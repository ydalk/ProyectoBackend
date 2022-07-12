$(document).ready(function(){
    (function(){
        $.ajax({
            type : "GET",
            url : "/odontologos",
            success: function(response){
              $.each(response, (i, odontologo) => {


                let edit_Btn = '<button' +
                                    ' type="button" class="btn_ico btn_edit_id" data-open="update_odontologo_form">' +
                                    '<img' + ' id=' + '\"' + 'btn_id_' + odontologo.id + '\"' + 'class= "icon" src="../images/userEdit.png">' +
                                    '</button>';

                let delete_Btn = '<button' +
                                    ' type="button" onClick="deleteBy('+ odontologo.id + ')" class="btn_ico btn_delete_id">' +
                                     '<img '+ 'id=' + '\"' + 'btn_id_' + odontologo.id + '\"' + 'class="icon" src="../images/userDelete.png">' +
                                    '</button>';

                let tr_id = 'tr_' + odontologo.id;
                let odontologoRow = '<tr id=\"' + tr_id + "\"" + '>' +
                          '<td class=\"td_id\">' + odontologo.id + '</td>' +
                          '<td class=\"td_first_name\">' + odontologo.nombre + '</td>' +
                          '<td class=\"td_last_name\">' + odontologo.apellido + '</td>' +
                          '<td class=\"td_matricula\">' + odontologo.matricula + '</td>' +
                          '<td>' + delete_Btn + edit_Btn + '</td>' +
                          '</tr>';
                $('#odontologoTable tbody').append(odontologoRow);
              });
            },
            error : function(e) {
              alert("ERROR: ", e);
              console.log("ERROR: ", e);
            }
        });
    })();

    (function(){
        let pathname = window.location.pathname;
        if (pathname == "/odontologos.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();
});