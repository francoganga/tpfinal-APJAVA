/*!
 * Start Bootstrap - SB Admin 2 v3.3.7+1 (http://startbootstrap.com/template-overviews/sb-admin-2)
 * Copyright 2013-2016 Start Bootstrap
 * Licensed under MIT (https://github.com/BlackrockDigital/startbootstrap/blob/gh-pages/LICENSE)
 */
$(function() {
    $('#side-menu').metisMenu();
});

//Loads the correct sidebar on window load,
//collapses the sidebar on window resize.
// Sets the min-height of #page-wrapper to window size
$(function() {
    $(window).bind("load resize", function() {
        var topOffset = 50;
        var width = (this.window.innerWidth > 0) ? this.window.innerWidth : this.screen.width;
        if (width < 768) {
            $('div.navbar-collapse').addClass('collapse');
            topOffset = 100; // 2-row-menu
        } else {
            $('div.navbar-collapse').removeClass('collapse');
        }

        var height = ((this.window.innerHeight > 0) ? this.window.innerHeight : this.screen.height) - 1;
        height = height - topOffset;
        if (height < 1) height = 1;
        if (height > topOffset) {
            $("#page-wrapper").css("min-height", (height) + "px");
        }
    });

    var url = window.location;
    // var element = $('ul.nav a').filter(function() {
    //     return this.href == url;
    // }).addClass('active').parent().parent().addClass('in').parent();
    var element = $('ul.nav a').filter(function() {
        return this.href == url;
    }).addClass('active').parent();

    while (true) {
        if (element.is('li')) {
            element = element.parent().addClass('in').parent();
        } else {
            break;
        }
    }

    $("a[name='test1']").click(function() {
        // Prevent the form from submitting via the browser.
        
        ajaxGet();
    });


    function ajaxGet(){
        $.ajax({
            type : "GET",
            url : "/alumnoRest",
            success: function(result){
                if(result.status == "Done"){
                    $('#datos').append(result.data[0] + "<br>")
                    $('#datos').append(result.data[1] + "<br>")
                    $('#datos').append(result.data[2])
                    console.log("Success: ", result);
                }else{
                    $("#datos").html("<strong>Error</strong>");
                    console.log("Fail: ", result);
                }
            },
            error : function(e) {
                $("#datos").html("<strong>Error</strong>");
                console.log("ERROR: ", e);
            }
        }); 
    }
    cargarProblemas();
    function cargarProblemas(){
        $.ajax({
            type : "GET",
            url : "/cargarProblemas",
            success: function(result){
                if(result.status == "Done"){
                    for(i=0; i < result.data.length; i++){
                        $("#page-wrapper").append(
                            "<div class='row'>" +
                "<div class='col-lg-12'>" +
                    "<div class='panel panel-default'>" +
                        "<div class='panel-heading'>" +
                            "<a class='problem_link' href='#' id='" + result.data[i][3] +"'>    "+result.data[i][0] + "</a>"+
                            "<div class='pull-right'>" +
                                "<div class='btn-group'>" +
                                    "<button type='button' class='btn btn-default btn-xs dropdown-toggle' data-toggle='dropdown'>" +
                                        "Acciones" +
                                        "<span class='caret'></span>" +
                                    "</button>" +
                                    "<ul class='dropdown-menu pull-right' role='menu'>" +
                                        "<li><a name='test1' href='#'>Hacer cosa</a>" +
                                    "</ul>" +
                                "</div>" +
                            "</div>" +
                        "</div>" +
                        "<div class='panel-body'>" +
                            "<p>" + result.data[i][1] + 
                            "</p>" +
                        "</div>" +
                        "<div class='panel-footer'>" +
                        "</div>" +
                    "</div>" +
            "</div>"



                            );
                        
                    }
                    console.log("Success: ", result);
                }else{
                    
                    console.log("Fail: ", result);
                }
            },
            error : function(e) {
                
                console.log("ERROR: ", e);
            }
        }); 
    }

    $("body").on("click", ".problem_link", function(){
        window.location.href = "/problema?problemId=" + this.id;
    });

    $(".materia_search").click(function(){
        var materiaId = this.id;
        $("#page-wrapper").empty();
        $.ajax({
            type : "GET",
            url : "/filtrarMateria?materiaId=" + materiaId,
            success: function(result){
                if(result.status == "Done"){
                    for(i=0; i < result.data.length; i++){
                        $("#page-wrapper").append(
                            "<div class='row'>" +
                "<div class='col-lg-12'>" +
                    "<div class='panel panel-default'>" +
                        "<div class='panel-heading'>" +
                            "<a class='problem_link' href='#' id='" + result.data[i].id +"'>    "+result.data[i].title + "</a>"+
                            "<div class='pull-right'>" +
                                "<div class='btn-group'>" +
                                    "<button type='button' class='btn btn-default btn-xs dropdown-toggle' data-toggle='dropdown'>" +
                                        "Acciones" +
                                        "<span class='caret'></span>" +
                                    "</button>" +
                                    "<ul class='dropdown-menu pull-right' role='menu'>" +
                                        "<li><a name='test1' href='#'>Hacer cosa</a>" +
                                    "</ul>" +
                                "</div>" +
                            "</div>" +
                        "</div>" +
                        "<div class='panel-body'>" +
                            "<p>" + result.data[i].text + 
                            "</p>" +
                        "</div>" +
                        "<div class='panel-footer'>" +
                        "</div>" +
                    "</div>" +
            "</div>"



                            );
                        
                    }
                    
                    
                    console.log("Success: ", result);
                }else{
                    console.log("Fail: ", result);
                }
            },
            error : function(e) {
                console.log("ERROR: ", e);
            }
        });
    })

    




});
