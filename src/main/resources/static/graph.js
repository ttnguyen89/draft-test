function drawGraph(graph) {
	var backgroundColor= [
        'rgba(255, 99, 132, 0.2)',
        'rgba(54, 162, 235, 0.2)',
        'rgba(255, 206, 86, 0.2)',
        'rgba(75, 192, 192, 0.2)',
        'rgba(153, 102, 255, 0.2)',
        'rgba(255, 159, 64, 0.2)',
        'rgba(120, 75, 100, 0.2)',
        'rgba(153, 192, 86, 0.2)',
        'rgba(54, 162, 235, 0.2)',
        'rgba(100, 112, 60, 0.2)'
    ];
    var datasets = [];
    for(var i = 0; i < graph.length; i++) {
		var element = graph[i];
		var data = {};
		data.data = [];
		element.foreEach(function(value){
			data.data.push(value.salary);
		});
		data.backgroundColor = [backgroundColor[i]];
		data.borderColor = ['rgba(255,99,132,1)'];
		data.borderWidth = 1;
		datasets.push(data);
    }    
    
    $(document).ready(function() { 
    	var ctx = document.getElementById("graphId").getContext('2d');
    	var myChart = new Chart(ctx, {
    		type:'bar',
    		data: {
    			datasets: datasets
    		}
    	});
    });
}