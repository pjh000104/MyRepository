const body = document.querySelector('body');
const container = document.querySelector('#container');
const gridSizeBtn = document.querySelector('#gridSizeBtn');
const resetBtn = document.querySelector('#resetBtn');
const colorBlack = 'black';
const colorWhite = 'White';
let gridSize = 16;
makeGrid1();
draw(colorBlack);

//https://codepen.io/ElGodzilla06/pen/yLaQXXG
var colorPicker = document.getElementById("color-picker");
    var colorValue = document.getElementById("value");
    colorPicker.onchange = function() {
        colorValue.innerHTML = colorPicker.value;
        colorValue.style.color = colorPicker.value;
        draw(colorPicker.value);
    }
//

function makeGrid1() {
   for(let i = 0; i<gridSize; i++) {
      const gridBoxColumn = document.createElement('div');
      gridBoxColumn.setAttribute('id', 'gridBoxColumn');
      for(let j = 0; j<gridSize; j++) {
         const gridBoxRow = document.createElement('div');
         gridBoxRow.setAttribute('id', 'gridBoxRow');
         gridBoxColumn.appendChild(gridBoxRow);
      }
      container.appendChild(gridBoxColumn);
   }
}

function draw(color) {
   let gridBoxes = document.querySelectorAll('#gridBoxRow');
   for (let i = 0; i < gridSize*gridSize; i++) {
      gridBoxes[i].addEventListener('mouseover', function() {
         gridBoxes[i].style.backgroundColor = color;
         
      });
   }
}


gridSizeBtn.addEventListener('click', () => {
   const rowss = document.querySelectorAll('#gridBoxRow');
   const columnss = document.querySelectorAll('#gridBoxColumn');
   for(let i = 0; i<gridSize*gridSize; i++) {
      rowss[i].remove();
   }
   for(let i = 0; i<gridSize; i++) {
      columnss[i].remove();
   }
   gridSize = prompt("Enter Grid Size");
   makeGrid1();
   draw(colorPicker.value);
});

resetBtn.addEventListener('click', () => {
   let gridBoxes = document.querySelectorAll('#gridBoxRow');
   for (let i = 0; i < gridSize*gridSize; i++) {
         gridBoxes[i].style.backgroundColor = 'white';
   }
});

