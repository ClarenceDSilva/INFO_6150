/*global jQuery:false */

(function($) {
  'use strict';

  $('.toggle-faq-js').click(function() {
    $(this).toggleClass('faq-collection_question--visable');
    $(this).next('.faq-answer-js').slideToggle(150);
  });

  $('.toggle-faq-js').keypress(function(e) {
    var key = e.which;
    if (key === 13) // the enter key code
    {
      $(this).toggleClass('faq-collection_question--visable');
      $(this).next('.faq-answer-js').slideToggle(150);
    }
  });
})(jQuery);