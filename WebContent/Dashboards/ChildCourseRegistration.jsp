
<h1>Inscrire Mon enfant</h1>

    <div class="container">
      <h2>Selectionner l'enfant que vous souhaitez Inscrire</h2>

      <div class="select-box">
        <div class="options-container">
          <div class="option">
            <input
              type="radio"
              class="radio"
              id="Étoile_de_mer"
              name="category"
            />
            <label for="Étoile_de_mer">Étoile de mer</label>
          </div>

          <div class="option">
            <input type="radio" class="radio" id="Bambins" name="category" />
            <label for="Bambins">Bambins</label>
          </div>

          <div class="option">
            <input type="radio" class="radio" id="Tortues" name="category" />
            <label for="Tortues">Tortues</label>
          </div>

          <div class="option">
            <input type="radio" class="radio" id="Pingouins" name="category" />
            <label for="Pingouins">Pingouins</label>
          </div>

          <div class="option">
            <input type="radio" class="radio" id="Salamandre" name="category" />
            <label for="Salamandre">Salamandre</label>
          </div>

          <div class="option">
            <input type="radio" class="radio" id="Baleines" name="category" />
            <label for="Baleines">Baleines</label>
          </div>

          <div class="option">
            <input type="radio" class="radio" id="Grenouilles" name="category" />
            <label for="Grenouilles">Grenouilles</label>
          </div>

          <div class="option">
            <input type="radio" class="radio" id="Dauphins" name="category" />
            <label for="Dauphins">Dauphins</label>
          </div>

          <div class="option">
            <input type="radio" class="radio" id="Maître_Nageur" name="category" />
            <label for="Maître_Nageur">Maître-Nageur</label>
          </div>
        </div>

        <div class="selected">
          Selectionnez ici
        </div>
      </div>
    </div>

    <script  type="text/javascript">
    const selected = document.querySelector(".selected");
    const optionsContainer = document.querySelector(".options-container");

    const optionsList = document.querySelectorAll(".option");

    selected.addEventListener("click", () => {
      optionsContainer.classList.toggle("active");
    });

    optionsList.forEach(o => {
      o.addEventListener("click", () => {
        selected.innerHTML = o.querySelector("label").innerHTML;
        optionsContainer.classList.remove("active");
      });
    });
    </script>
    
    
	 <style>


body {
  font-family: "Roboto", sans-serif;
  background: #f7f6ff;
}

h2 {
  margin: 16px;
}

.container {
  margin-top: 100px;
  padding: 32px;
}

.select-box {
  display: flex;
  width: 400px;
  flex-direction: column;
}

.select-box .options-container {
  background: #2f3640;
  color: #f5f6fa;
  max-height: 0;
  width: 100%;
  opacity: 0;
  transition: all 0.4s;
  border-radius: 8px;
  overflow: hidden;

  order: 1;
}

.selected {
  background: #2f3640;
  border-radius: 8px;
  margin-bottom: 8px;
  color: #f5f6fa;
  position: relative;

  order: 0;
}

.selected::after {
  content: "";
  background: url("./img/arrow-down.svg");
  background-size: contain;
  background-repeat: no-repeat;

  position: absolute;
  height: 100%;
  width: 32px;
  right: 10px;
  top: 5px;

  transition: all 0.4s;
}

.select-box .options-container.active {
  max-height: 240px;
  opacity: 1;
  overflow-y: scroll;
}

.select-box .options-container.active + .selected::after {
  transform: rotateX(180deg);
  top: -6px;
}

.select-box .options-container::-webkit-scrollbar {
  width: 8px;
  background: #0d141f;
  border-radius: 0 8px 8px 0;
}

.select-box .options-container::-webkit-scrollbar-thumb {
  background: #525861;
  border-radius: 0 8px 8px 0;
}

.select-box .option,
.selected {
  padding: 12px 24px;
  cursor: pointer;
}

.select-box .option:hover {
  background: #414b57;
}

.select-box label {
  cursor: pointer;
}

.select-box .option .radio {
  display: none;
}
	 
		</style>