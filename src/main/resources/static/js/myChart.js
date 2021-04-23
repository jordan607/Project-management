new Chart(document.getElementById("myPieChart"), {
	type: 'pie',

	data: {
  	labels: ['January','February','March','April','May'],
  	datasets: [{
    label: 'My First dataset',
    backgroundColor: ["##DFFF00","#6495ED","#FFBF00","#DE3163", "#CCCCFF"],
    borderColor: 'rgb(255, 99, 132)',
    data: [20, 10, 5, 2, 20],
  		}]
	},
	options: {}
});