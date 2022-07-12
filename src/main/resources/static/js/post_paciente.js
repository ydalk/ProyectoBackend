$(document).ready(function() {
    $("#add_new_paciente").submit(function(evt) {
        evt.preventDefault();


        let formDataDom = {
            calle : $("#calle").val(),
            numero :  $("#numero").val(),
            localidad: $("#localidad").val(),
            provincia: $("#provincia").val(),
        }

        let direccion = formDataDom.calle + " " + formDataDom.numero + " " + formDataDom.localidad + " " + formDataDom.provincia

        let formData = {
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
            url: '/pacientes/nuevo',
            type: 'POST',
            contentType : "application/json",
            data: JSON.stringify(formData),
            dataType : 'json',
            async: false,
            cache: false,
            success: function (response) {
                let paciente = response
                console.log(response)
                let successAlert = '<div class="alert alert-success alert-dismissible">' +
                    '<strong></strong> paciente agregado </div>'
                $("#response").append(successAlert);
                $("#response").css({"display": "block"});

                resetUploadForm();
            },
            error: function (response) {
                let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                    '<strong> Error intente nuevamente</strong> </div>'
                $("#response").append(errorAlert);
                $("#response").css({"display": "block"});

                resetUploadForm();
            }
        });
    });


    function resetUploadForm(){
        $("#nombre").val("");
        $("#apellido").val("");
        $("#dni").val("");
        $("#fecha_ingreso").val("");
        $("#domicilio").val("");

    }

    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            $(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/pacientes.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();
});