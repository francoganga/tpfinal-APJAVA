$(document).ready(function(){
	$(".materia_search").click(function(){
        var materiaId = this.id;
        window.location.href = "/filtrarProblema?materiaId=" + materiaId;
    });
    $(".tutor_search").click(function(){
        var materiaId = this.id;
        window.location.href = "/filtrarTutor?materiaId=" + materiaId;
    });

});
