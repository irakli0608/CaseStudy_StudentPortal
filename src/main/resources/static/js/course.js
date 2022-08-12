const getUserSelectedText = () => {
  return window.getSelection().toString();
};

const button = document.getElementById("btn");
const list = document.getElementById("list");

list.style.display = "none";

button.addEventListener("click", (event) => {
  if (list.style.display == "none") {
    list.style.display = "block";
  } else {
    list.style.display = "none";
  }
});


var select = document.getElementById("selectCourse");
var options = ["English", "Math", "Orgo", "Chem", "Biology"];
for(var i = 0; i < options.length; i++) {
    var opt = options[i];
    var el = document.createElement("option");
    el.textContent = opt;
    el.value = opt;
    select.appendChild(el);
}

$('html, body').animate({ scrollTop: 0 }, 'fast');
