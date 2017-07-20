function search_google_books() {
  var script = document.createElement('script');
  var isbn = document.forms[0].isbn;
  if ( isbn && isbn.value != '' ) {
    //alert( isbn.value );
    document.getElementById('thumbnail').innerHTML = '<img src="./loading.gif" />';
    script.src = 'https://www.googleapis.com/books/v1/volumes?callback=show_bookcover&q=isbn:' + isbn.value;
    document.body.appendChild(script);
  } else {
    alert( 'Please input ISBN!' );
  }
}
function show_bookcover(booksInfo){
  var link = '<span class="nolink">No image available...</span>';
  for (i in booksInfo.items) {
    var book = booksInfo.items[i]
    var image = book.volumeInfo.imageLinks;
    if (image && image.thumbnail != undefined)  {
      var thumbnail = image.thumbnail.replace('zoom=5', 'zoom=1');
      if ( document.location.protocol == 'https:' ) {
        var parser = document.createElement('a');
        parser.href = thumbnail;
	parser.protocol = 'https:';
        parser.hostname = 'encrypted.google.com';
        thumbnail = parser.href;
      }
      link = '<img src="' + thumbnail + '" />';
      if (book.accessInfo && book.accessInfo.viewability != "NO_PAGES") {
        var preview = book.volumeInfo.previewLink;
	link += '<br /><a href="' + preview + '" target="_blank"><img border=0 src="//www.google.com/googlebooks/images/gbs_preview_button1.gif" title="Google Preview" alt="Google Preview" /></a>';
      }
    }
    link += '<br />'+ book.volumeInfo.title;
    if (book.volumeInfo.authors.length > 0) {
      link += '<br />' + book.volumeInfo.authors.join("; ");
    }
  }
  document.getElementById('thumbnail').innerHTML = link;
}