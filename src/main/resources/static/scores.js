let scores = document.getElementsByClassName("collapsible");
var i;

for (i = 0; i < scores.length; i++) {
  scores[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var content = this.nextElementSibling;
    if (content.style.maxHeight){
      content.style.maxHeight = null;
    } else {
      content.style.maxHeight = content.scrollHeight + "px";
    }
  });
}