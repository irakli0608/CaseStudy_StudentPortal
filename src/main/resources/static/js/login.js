
function validate() {
  let password = document.querySelector("#Password");
  let upper = document.querySelector("#upper");
  let lower = document.querySelector("#lower");
  let symbol = document.querySelector("#symbol");
  let number = document.querySelector("#number");
  let length = document.querySelector("#length");

if (password.value.match(/[0-9]/)) {
    number.style.color = "green";
  } else {
    number.style.color = "red";
  }

  //validate uppercase
  if (password.value.match(/[A-Z]/)) {
    upper.style.color = "green";
  } else {
    upper.style.color = "red";
  }

  //validate lowercase
  if (password.value.match(/[a-z]/)) {
    lower.style.color = "green";
  } else {
    lower.style.color = "red";
  }

  //validate symbol
  if (password.value.match(/[!\@\#\$\%\^\&\,]/)) {
    symbol.style.color = "green";
  } else {
    symbol.style.color = "red";
  }

  //length

  if (password.value.length < 6) {
    length.style.color = "red";
  } else {
    length.style.color = "green";

    }  
  }
    function confirmPassword() {
      let password = document.querySelector("Password");
      let password2 = document.querySelector("#pass2");
    
      if (password == password2) {
        document.querySelector("#upper").style.display = "none";
        document.querySelector("#lower").style.display = "none";
        document.querySelector("#symbol").style.display = "none";
        document.querySelector("#number").style.display = "none";
        document.querySelector("#length").style.display = "none";
      } else {
        document.querySelector("#upper").style.display = "block";
        document.querySelector("#lower").style.display = "block";
        document.querySelector("#symbol").style.display = "block";
        document.querySelector("#number").style.display = "block";
        document.querySelector("#length").style.display = "block";
      }
    }