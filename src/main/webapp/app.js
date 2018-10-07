
const fetchGeneral = (url, cb) => {
	fetch(url)
		.then(function (response) {
			return response.json();
		})
		.then(function (json) {
			cb(json);
		})
		.catch(function (error) {
			console.log('Error: ' + error);
		});
};

document.getElementById("search").addEventListener("click", function (){
    const choise = document.getElementById("choise").value;
    //console.log(choise);
    fetchGeneral('http://localhost:8084/CourseAssignment/api/' + choise, json => {
	console.log(json);
});
    
});

