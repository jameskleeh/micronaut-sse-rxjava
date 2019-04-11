var evtSource = new EventSource("/hello/events");

evtSource.onmessage = function(e) {
    var newElement = document.createElement("li");
    var eventList = document.getElementById('list');
    var data = JSON.parse(e.data);
    newElement.innerHTML = "message: " + data.name;
    eventList.appendChild(newElement);
};