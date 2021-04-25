var chartDataStr = decodeHtml(chartData);
var chartJsonArray = JSON.parse(chartDataStr);

var arrayLength = chartJsonArray.length;
var stage =[];
var projectChart =[];

for(var i=0; i< arrayLength; i++){
	stage[i] = chartJsonArray[i].stage;
	projectChart[i] = chartJsonArray[i].projectChart;
	
}

new Chart(document.getElementById("myPieChart"), {
	type: 'pie',

	data: {
  	labels: stage,
  	datasets: [{
    label: 'Project Status',
    backgroundColor: ["##DFFF00","#6495ED","#FFBF00"],
    borderColor: 'rgb(255, 99, 132)',
    data: projectChart,
  		}]
	},
	options: {
		title :{
			display: true,
			text: 'Project Status'
			
		}
		
	}
});

function decodeHtml(html){
	var txt = document.createElement("textarea");
	txt.innerHTML =html;
	return txt.value;
}