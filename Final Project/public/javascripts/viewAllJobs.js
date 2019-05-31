$(document).ready(function(){
  var li = $('li');
  TweenMax
    .staggerTo(li, 0.25, {css: {opacity: "1", display:"block"}}, 0.25);  
    //.from(a, 2, {autoAlpha: 0});
    //.from(h3, 2, {autoAlpha: 0});
});