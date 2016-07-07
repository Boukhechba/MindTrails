function adapt(){
if ($(window).width() < 414) {
    $('.section').removeClass('section-H');
    $('.section').addClass('section-V');
  } else {
    $('.section').addClass('section-H');
    $('.section').removeClass('section-V');
  }
}

function scrollTo(elem){console.log(elem)
$('html,body').animate({
scrollTop: elem.offset().top},'slow');}

$(document).on('click', 'table tr:last-child', function(e){
    scrollTo($(this).closest(".section").next());

});

$(document).ready(adapt);

$(window).resize(adapt);