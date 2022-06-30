 'use strict';

 $(document).ready(function(){
     /* 리뷰 팝업창 내용에 맞게 크기 조절 */
     var strDocumentWidth = $(document).outerWidth();
     var strDocumentHeight = $(document).outerHeight();
     
     console.log(strDocumentWidth, strDocumentHeight);
     window.resizeTo ( strDocumentWidth, strDocumentHeight );
     
     var strMenuWidth = strDocumentWidth - $(window).width();
     var strMenuHeight = strDocumentHeight - $(window).height();

     var strWidth = $('#container').outerWidth() + strMenuWidth;
     var strHeight = $('#container').outerHeight() + strMenuHeight;
     
     window.resizeTo( strWidth, strHeight );
    
//--$(document).ready
});
 