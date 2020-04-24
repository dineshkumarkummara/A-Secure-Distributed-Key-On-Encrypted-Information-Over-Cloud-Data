var photos = [
  { Image: '1.jpg', Date: '27 Oct 2011', About: 'This is description about 1.jpg' },
  { Image: '2.jpg', Date: '28 Oct 2011', About: 'This is description about 2.jpg' },
  { Image: '3.jpg', Date: '29 Oct 2011', About: 'This is description about 3.jpg' },
  { Image: '4.jpg', Date: '30 Oct 2011', About: 'This is description about 4.jpg' }
];

$(function(){
    // prepare own custom templates
    $.template('simplePhotos', '<a tabindex="1"><img src="images/${Image}"></a>');

    $.template('simpleArticles', '<div class="sim"><img src="images/${Image}"><div><p></p><p>more details</p></div></div>');
    $.template('extendedArticles', '<div class="ext"><img src="images/${Image}"><div><p>${Date}</p><p>${About}</p></div></div>');

    var selectedItem = null;

    // render Photos and Articles through prepared templates
    $.tmpl('simplePhotos', photos).appendTo('#gallery');
    $('<span class="close"></span>').appendTo('#gallery');

    $.tmpl('simpleArticles', photos ).appendTo('#articles');

    // onclick handling
    $('#articles').delegate('.sim', 'click', function () {
      if (selectedItem) {
        // render via Simple template
        selectedItem.tmpl = $.template('simpleArticles');
        selectedItem.update();
      }

      selectedItem = $.tmplItem(this);

      // render via Extended template
      selectedItem.tmpl = $.template('extendedArticles');
      selectedItem.update();
    }).delegate( '.ext', 'click', function () {
      // render via Simple template 
      selectedItem.tmpl = $.template('simpleArticles');
      selectedItem.update();

      selectedItem = null;
    });
});