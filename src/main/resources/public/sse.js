var evtSource = new EventSource("/author/events");

evtSource.onmessage = function(e) {
    var newElement = document.createElement("li");
    var eventList = document.getElementById('list');
    var data = JSON.parse(e.data);
    newElement.innerHTML = "message: " + data.name;
    eventList.appendChild(newElement);
};
