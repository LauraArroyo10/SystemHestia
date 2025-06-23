//Cosas encontradas en el camino


//@JsonInclude(JsonInclude.Include.NON_NULL):   Si un atributo tiene un valor null, no aparecerá en el JSON resultante.


// Spring Security
//https://www.youtube.com/watch?v=nwqQYCM4YT8


//fetch = FetchType.LAZY → Specifies lazy loading, meaning the related entity is only fetched from the database when needed.

// como hacer que la aplicacion envie emails : https://www.youtube.com/watch?v=ugIUObNHZdo

//fetch = FetchType.EAGER
//Esto define cómo se comporta la carga de datos cuando hacés una consulta.
//EAGER (ansioso): el objeto relacionado se carga automáticamente junto con la entidad principal.
        //Ej: si buscás un Treatment, también se traerá automáticamente el Patient, Medicine y Disease asociados.

//cascade = CascadeType.MERGE) > con esto se hace un enlace entre las entidades, por eso si se pide que cargue
//la entidad de tratamiento, no lo va a hacer porque necesita que ya exista el paciente

// @ToString.Exclude:Es una anotación de Lombok que evita que un campo se incluya automáticamente en
// //el metodo toString() que genera @ToString.