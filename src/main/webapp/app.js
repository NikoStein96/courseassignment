
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



document.getElementById("search").addEventListener("click", function () {
    const choise = document.getElementById("choise").value;
    //console.log(choise);
    fetchGeneral('http://localhost:8084/CourseAssignment/api/' + choise, json => {
        console.log(json);
        if (choise === "city/danishzips") {
            var s = "<table><tr> <th>postnr</th> <th>by</th> </tr>";
            for (var i = 0, max = json.length; i < max; i++) {
                s += "<tr>";
                s += "<td>" + json[i].zipCode + "</td>";
                s += "<td>" + json[i].city + "</td>";
                s += "</tr>";
            }
            s += "</table>";

            document.getElementById("fetcheddata").innerHTML = s;
        } else if (choise === "company/bycphhone" || choise === "company/byemployees") {
            var s = "<table><tr> <th>name</th> <th>desc</th>  <th>cvr</th> <th>nrofemployees</th> <th>marketvalue</th></tr>";
            for (var i = 0, max = json.length; i < max; i++) {
                s += "<tr>";
                s += "<td>" + json[i].name + "</td>";
                s += "<td>" + json[i].description + "</td>";
                s += "<td>" + json[i].cvr + "</td>";
                s += "<td>" + json[i].numEmployees + "</td>";
                s += "<td>" + json[i].marketValue + "</td>";
                s += "</tr>";
            }
            s += "</table>";
            document.getElementById("fetcheddata").innerHTML = s;
        } else if (choise === "person/byphhone" || choise === "person/byhobby" || choise === "person/bycity") {
            var s = "<table><tr> <th>firstname</th> <th>lastname</th>  <th>hobbyer</th></tr>";
            for (var i = 0, max = json.length; i < max; i++) {
                s += "<tr>";
                s += "<td>" + json[i].firstName + "</td>";
                s += "<td>" + json[i].lastName + "</td>";
                s += "<td>" + json[i].hobbyer + "</td>";

                s += "</tr>";
            }
            s += "</table>";
            document.getElementById("fetcheddata").innerHTML = s;
        } else if (choise === "person/hobbysize") {
            document.getElementById("fetcheddata").innerHTML += json[0].size;
        }
    });

});

