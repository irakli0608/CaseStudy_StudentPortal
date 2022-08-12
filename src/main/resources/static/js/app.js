let btn = document.getElementById("btn");
let light = document.getElementById("light");
let question = document.getElementById("questions");
function toggleBtn() {
  btn.classList.toggle("active");
  light.classList.toggle("on");
  question.classList.toggle("questions");
}
function mouseOver(element) {
  element.style.color = "#00986f";
}
function mouseOut(element) {
  element.style.color = "white";
}
