package com.petrov;

public class Main7 {

    public static void main(String[] args) {

        shortWay();
    }

    private static void shortWay(){
        Graph graph = new GraphImpl(10);
        graph.addVertex("Moscow");
        graph.addVertex("Saratov");
        graph.addVertex("Kaluga");
        graph.addVertex("Orel");
        graph.addVertex("Kursk");
        graph.addVertex("Tula");
        graph.addVertex("Lipetsk");
        graph.addVertex("Voronezh");
        graph.addVertex("Riazan");
        graph.addVertex("Tambov");


        graph.addEdge("Moscow", "Tula", "Kaluga","Riazan");

        graph.addEdge("Riazan", "Tambov");
        graph.addEdge("Tambov", "Saratov");
        graph.addEdge("Saratov", "Voronezh");

        graph.addEdge("Kaluga", "Orel");
        graph.addEdge("Orel", "Kursk");
        graph.addEdge("Kursk", "Voronezh");

        graph.addEdge("Tula", "Lipetsk");
        graph.addEdge("Lipetsk", "Voronezh");

        graph.findShortPathViaDfs("Moscow", "Voronezh");

    }
}
