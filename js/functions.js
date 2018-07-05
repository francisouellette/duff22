
function Manager(name,v1, v2, v3,pic) {
    this.name=name;
    this.v1 = v1;
    this.v2 = v2;
    this.v3 = v3;
    this.chosen = false;
    this.pic=pic;
    
}; 
var clicks = 0;
    var player6 = new Manager("Thomas",3, 3, 4,"logo_duff/norris.jpg");
    var player5 = new Manager("Curtis",5, 5, 6,"logo_duff/curtis.jpg");
    var player4 = new Manager("Jonas",6, 7, 7,"logo_duff/saad.png");
    var player3 = new Manager("Ben",8, 8, 9,"logo_duff/ben.png");
    var player2 = new Manager("stef",10, 10, 10,"logo_duff/stef.jpg");
    var player1 = new Manager("Nathan",18, 16, 14,"logo_duff/Matthews.jpg");
	
    var total = 0;

    var list = [player1, player2, player3, player4, player5, player6];
    var weight = [player1.v1, player2.v1, player3.v1, player4.v1, player5.v1, player6.v1];


var rand = function (min, max) {
    return Math.random() * (max - min) + min;
};

var recalculateTotal = function(list){
    total = 0;

     for (var i = 0; i < list.length; i++){
        if(list[i].chosen==false){
            console.log(list[i].name+ " " + list[i].v3);

            total+=list[i].v3
        }
    }
    console.log("total = "+ total);
    return total;
}

var getRandomItem = function(list){
    total = recalculateTotal(list);
    var random_num = rand(0, total);
    var weight_sum = 0;
     
    for (var i = 0; i < list.length; i++) {
        if(list[i].chosen==false){
            weight_sum += list[i].v3;
            weight_sum =+ weight_sum.toFixed(2);
            if (random_num <= weight_sum) {
                list[i].chosen=true;
                return list[i];

            }
        }
    }
};

function updateRankings(list){
    total=recalculateTotal(list);
     if(!list[0].chosen){
                    document.getElementById("p1").innerHTML = Math.round((list[0].v2/total)*100) + "%";
            }else{
                document.getElementById("p1").innerHTML = "-";

            }
          if(!list[1].chosen){
                    document.getElementById("p2").innerHTML = Math.round((list[1].v2/total)*100) + "%";
            }else{
                document.getElementById("p2").innerHTML = "-";

            }
          if(!list[2].chosen){
                    document.getElementById("p3").innerHTML = Math.round((list[2].v2/total)*100) + "%";
            }else{
                document.getElementById("p3").innerHTML = "-";

            }
          if(!list[3].chosen){
                    document.getElementById("p4").innerHTML = Math.round((list[3].v2/total)*100) + "%";
            }else{
                document.getElementById("p4").innerHTML = "-";

            }
          if(!list[4].chosen){
                    document.getElementById("p5").innerHTML = Math.round((list[4].v2/total)*100) + "%";
            }else{
                document.getElementById("p5").innerHTML = "-";

            }
            if(!list[5].chosen){
                    document.getElementById("p6").innerHTML = Math.round((list[5].v2/total)*100) + "%";
            }else{
                document.getElementById("p6").innerHTML = "-";

            }
    
}

function myScript(){


    if(clicks==0){
            var chosen1 = getRandomItem(list);
            document.getElementById("firstName").innerHTML = chosen1.name;
            document.getElementById("firstPic").src = chosen1.pic;
            clicks++;
            updateRankings(list);
            console.log(clicks)

           
    }
    else if(clicks==1){
            var chosen2 = getRandomItem(list);
            document.getElementById("secondName").innerHTML = chosen2.name;
            document.getElementById("secondPic").src = chosen2.pic;
            clicks++;
            updateRankings(list);

       }
    else if(clicks==2){
            var chosen3 = getRandomItem(list);
            document.getElementById("thirdName").innerHTML = chosen3.name;
            document.getElementById("thirdPic").src = chosen3.pic;
            updateRankings(list);

            clicks++;
       }
    }

document.getElementById("myBtn").addEventListener("click", myScript); 


