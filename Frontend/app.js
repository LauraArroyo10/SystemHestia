



const URL_API = 'http://localhost:8080/api/modulos'; // Cambia esta URL según tu API

fetch(URL_API)
  .then(response => response.json())
  .then(data => {
    const contenedor = document.getElementById('lista-modulos');
    data.forEach(modulo => {
      const item = document.createElement('div');
      item.textContent = `ID: ${modulo.id}, Nombre: ${modulo.nombre}`;
      contenedor.appendChild(item);
    });
  })
  .catch(error => {
    console.error('Error al obtener los datos:', error);
  });
