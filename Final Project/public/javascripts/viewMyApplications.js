$(document).ready(function(){
    $(".close").click(function(){
        $(".overlay").hide();
        
        $(".job-info2").hide();
        $(".job-info1").hide();
    });
    $("#show-more1").click(function(){
        $(".overlay").slideDown("fast");
        $(".job-info1").slideDown("fast");
    });

    $("#show-more2").click(function(){
        $(".overlay").slideDown("fast");
        $(".job-info2").slideDown("fast");
    });
});