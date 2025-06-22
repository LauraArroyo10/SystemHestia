const apiUrl = "http://localhost:8080/api/reports";

function loadReports() {
    fetch(apiUrl)
        .then(response => response.json())
        .then(data => {
            const list = document.getElementById("reportList");
            list.innerHTML = "";
            data.forEach(report => {
                const item = document.createElement("li");
                item.textContent = `${report.id} - ${report.title} - ${report.description}`;
                list.appendChild(item);
            });
        })
        .catch(error => console.error("Error al cargar reportes:", error));
}

function createReport() {
    const title = document.getElementById("title").value;
    const description = document.getElementById("description").value;
    const patientId = parseInt(document.getElementById("patientId").value);
    const medicineId = parseInt(document.getElementById("medicineId").value);

    const report = {
        title: title,
        description: description,
        patientId: patientId,
        medicineId: medicineId
    };

    fetch(apiUrl, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(report)
    })
        .then(response => {
            if (response.ok) {
                alert("Reporte creado con éxito");
                loadReports();
            } else {
                alert("Error al crear reporte");
            }
        })
        .catch(error => console.error("Error al crear reporte:", error));
}
