
function main() {
  var $skillset = $('.skillset');
  $('.skillset').hide();
  $('.skillset').fadeIn(1000);
  //alert($skillset);
  
  $('.projects').hide();
  $('.projects-button').on('click', function() {
    $(this).next().slideToggle(400);
    $(this).toggleClass('active');
    $(this).text('Projects Viewed');
  });
}

$(document).ready(main);