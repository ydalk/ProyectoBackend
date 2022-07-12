$(document).ready(function(){
    $("#update_paciente_form").submit(function(evt) {
        evt.preventDefault();
        try {
            let pacienteId = $("#paciente_id").val();

        let formData = {
            id: $("#paciente_id").val(),
            nombre : $("#nombre").val(),
            apellido :  $("#apellido").val(),
            dni: $("#dni").val(),
            fecha_ingreso: $("#fecha_ingreso").val(),
            domicilio: {
                calle : $("#calle").val(),
                numero :  $("#numero").val(),
                localidad: $("#localidad").val(),
                provincia: $("#provincia").val(),
            }
        }

            $.ajax({
                url: '/pacientes/actualizar',
                type: 'PUT',
                contentType : "application/json",
                data: JSON.stringify(formData),
                dataType : 'json',
                async: false,
                cache: false,
                success: function (response) {

                    let paciente = response;
                    let direccion = paciente.domicilio.calle + " " + paciente.domicilio.numero + " " + paciente.domicilio.localidad + " " + paciente.domicilio.provincia;

                    let successAlert = '<div class="alert alert-success alert-dismissible">' +
                                            '<strong> paciente actualizado </strong></div>'


                    $("#tr_" + pacienteId + " td.td_first_name").text(paciente.nombre);
                    $("#tr_" + pacienteId + " td.td_last_name").text(paciente.apellido);
                    $("#tr_" + pacienteId + " td.td_dni").text(paciente.dni);
                    $("#tr_" + pacienteId + " td.td_fecha_ingreso").text(paciente.fecha_ingreso);
                    $("#tr_" + pacienteId + " td.td_domicilio").text(direccion);

                    $("#response").empty();
                    $("#response").append(successAlert);
                    $("#response").css({"display": "block"});
                },

                error: function (response) {
                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                        '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                        '<strong> Error </strong></div>';

                    $("#response").empty();
                    $("#response").append(errorAlert);
                    $("#response").css({"display": "block"});
                }
            });
        } catch(error){
            console.log(error);
            alert(error);
        }
    });

    $(document).on("click", "table button.btn_edit_id", function(){
        let id_of_button = (event.srcElement.id);
        let pacienteId = id_of_button.split("_")[2];

        $.ajax({
            url: '/pacientes/' + pacienteId,
            type: 'GET',
            success: function(response) {
                let paciente = response;
                $("#paciente_id").val(paciente.id);
                $("#nombre").val(paciente.nombre);
                $("#apellido").val(paciente.apellido);
                $("#dni").val(paciente.dni);
                $("#fecha_ingreso").val(paciente.fecha_ingreso);
                $("#calle").val(paciente.domicilio.calle);
                $("#numero").val(paciente.domicilio.numero);
                $("#localidad").val(paciente.domicilio.localidad);
                $("#provincia").val(paciente.domicilio.provincia);
                $("#paciente_update").css({"display": "block"});
            },
            error: function(error){
                console.log(error);
                alert("Error -> " + error);
            }
        });
    });

    $(document).on("click", "btn-update", function(){
        $("#response").css({"display": "block"});
    });
});