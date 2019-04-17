package polyguide.buldingsmap;

import android.graphics.Point;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;


public class Graph {

    public static final Graph NINEGRAPH;
    public static final Graph MAINGRAPH;

    private List<Vertex> vertexList;
    private HashMap<Vertex, List<Vertex>> connections;


    public Graph() {
        vertexList = new ArrayList<Vertex>();
        connections = new HashMap<>();
    }

    public void addVertex(Vertex vertex) {
        vertexList.add(vertex);
    }

    public void addConnectionsInTwoSides(Vertex from, Vertex to) {
        addConnection(from, to);
        addConnection(to, from);
    }

    public void addConnection(Vertex from, Vertex to) {
        List<Vertex> curConnections = connections.get(from);
        if (curConnections == null) {
            curConnections = new ArrayList<>();
        }
        curConnections.add(to);
        connections.put(from, curConnections);
    }

    public List<Vertex> getConnections(Vertex vertex) {
        return connections.get(vertex);
    }

    public List<Vertex> getVertexList() { return vertexList;}

    // поиск пути между двумя вершинами графа
    public List<Vertex> searchWay(Vertex from, Vertex to) {
        Set<Vertex> visitedVertex = new HashSet<>();
        Stack<Vertex> stack = new Stack();
        Vertex curVertex = from;
        while (true) {
            stack.push(curVertex);
            if (curVertex.equals(to)) {
                break;
            }
            visitedVertex.add(curVertex);
            List<Vertex> candidates = getConnections(curVertex);
            List<Vertex> candidatesCopy = new ArrayList<>(candidates);
            for (Vertex canVertex : candidatesCopy) {
                if (visitedVertex.contains(canVertex)) {
                    candidates.remove(canVertex);
                }
            }
            if (candidates.isEmpty()) {
                stack.pop();
                curVertex = stack.pop();
            } else {
                for (Vertex canVertex : candidates) {
                    curVertex = candidates.get(0);
                    if (canVertex.equals(to)) {
                        curVertex = canVertex;
                    }
                }

            }

        }
        return stack;
    }

    static {
        NINEGRAPH = new Graph();
        MAINGRAPH = new Graph();

        Vertex firstFRightStairs = new Vertex("правая лестница", new Point(690, 276), 1);
        Vertex firstFK133 = new Vertex("133", new Point(710, 276), 1);
        Vertex firstFDRightStairs = new Vertex("ниже правой лестницы", new Point(690, 300), 1);
        Vertex firstFK131one = new Vertex("131 подход", new Point(739, 300), 1);
        Vertex firstFK131two = new Vertex("131", new Point(739, 334), 1);
        Vertex firstFB120and135 = new Vertex("между 120 и 135", new Point(691, 247), 1);
        Vertex firstFK120 = new Vertex("120", new Point(674, 247), 1);
        Vertex firstFK135 = new Vertex("135", new Point(712, 247), 1);
        Vertex firstFB120Aand137 = new Vertex("между 120а и 137", new Point(691, 137), 1);
        Vertex firstFK137 = new Vertex("137", new Point(724, 137), 1);
        Vertex firstFK120a = new Vertex("120a", new Point(669, 137), 1);
        Vertex firstFB101and139 = new Vertex("между 139 и 101", new Point(691, 93), 1);
        Vertex firstFK101 = new Vertex("101", new Point(668, 93), 1);
        Vertex firstFK139 = new Vertex("139", new Point(734, 80), 1);
        Vertex firstFMToilet = new Vertex("мужской туалет", new Point(654, 73), 1);
        Vertex firstFK129 = new Vertex("129", new Point(676, 323), 1);

        Vertex firstFK127one = new Vertex("127 подход", new Point(642, 300), 1);
        Vertex firstFK127two = new Vertex("127", new Point(642, 330), 1);
        Vertex firstFK125one = new Vertex("125 подход", new Point(602, 300), 1);
        Vertex firstFK125two = new Vertex("125", new Point(602, 330), 1);
        Vertex firstFK123one = new Vertex("123 подход", new Point(567, 300), 1);
        Vertex firstFK123two = new Vertex("123", new Point(567, 330), 1);
        Vertex firstFB121and118 = new Vertex("между 121 и 118", new Point(538, 300), 1);
        Vertex firstFK121 = new Vertex("121", new Point(538, 322), 1);
        Vertex firstFK119 = new Vertex("119", new Point(516, 322), 1);
        Vertex firstFK118Cafeteria = new Vertex("118 кафе", new Point(538, 285), 1);
        Vertex firstFK116Aone = new Vertex("116а подход", new Point(485, 300), 1);
        Vertex firstFK116Atwo = new Vertex("116а", new Point(485, 278), 1);
        Vertex firstFK116one = new Vertex("116 подход", new Point(394, 300), 1);
        Vertex firstFK116two = new Vertex("116", new Point(394, 278), 1);
        Vertex firstFK114one = new Vertex("114 подход", new Point(354, 300), 1);
        Vertex firstFK114two = new Vertex("114", new Point(354, 278), 1);
        Vertex firstFB112and117 = new Vertex("между 112 и 117", new Point(295, 300), 1);
        Vertex firstFK112 = new Vertex("112", new Point(295, 278), 1);
        Vertex firstFK117 = new Vertex("117", new Point(295, 324), 1);
        Vertex firstFK110one = new Vertex("110 подход", new Point(254, 300), 1);
        Vertex firstFK110two = new Vertex("110", new Point(254, 278), 1);
        Vertex firstFK108one = new Vertex("108 подход", new Point(218, 300), 1);
        Vertex firstFK108two = new Vertex("108", new Point(218, 278), 1);
        Vertex firstFK115 = new Vertex("115", new Point(194, 318), 1);
        Vertex firstFK113one = new Vertex("113 подход", new Point(162, 300), 1);
        Vertex firstFK113two = new Vertex("113", new Point(162, 318), 1);
        Vertex firstFK109A = new Vertex("109a", new Point(64, 296), 1);
        Vertex firstFK111 = new Vertex("111", new Point(64, 318), 1);
        Vertex firstFK109 = new Vertex("109", new Point(30, 318), 1);

        Vertex firstFLeftStairs = new Vertex("левая лестница", new Point(84, 273), 1);
        Vertex firstFDLeftStairs = new Vertex("ниже левой лестницы", new Point(84, 300), 1);
        Vertex firstFK107 = new Vertex("107", new Point(64, 273), 1);
        Vertex firstFK105one = new Vertex("подход 105", new Point(84, 186), 1);
        Vertex firstFK105two = new Vertex("105", new Point(36, 186), 1);
        Vertex firstFK103 = new Vertex("103", new Point(36, 169), 1);
        Vertex firstFK104 = new Vertex("104", new Point(110, 170), 1);
        Vertex firstFK106 = new Vertex("106", new Point(110, 196), 1);
        Vertex firstFB101and102 = new Vertex("между 101 и 102", new Point(84, 74), 1);
        Vertex firstFK101and100 = new Vertex("101 и 100", new Point(64, 67), 1);
        Vertex firstFK102 = new Vertex("102", new Point(110, 63), 1);


        NINEGRAPH.addVertex(firstFRightStairs);
        NINEGRAPH.addVertex(firstFK133);
        NINEGRAPH.addVertex(firstFDRightStairs);
        NINEGRAPH.addVertex(firstFK131one);
        NINEGRAPH.addVertex(firstFK131two);
        NINEGRAPH.addVertex(firstFB120and135);
        NINEGRAPH.addVertex(firstFK120);
        NINEGRAPH.addVertex(firstFK135);
        NINEGRAPH.addVertex(firstFB120Aand137);
        NINEGRAPH.addVertex(firstFK120a);
        NINEGRAPH.addVertex(firstFK137);
        NINEGRAPH.addVertex(firstFB101and139);
        NINEGRAPH.addVertex(firstFK101);
        NINEGRAPH.addVertex(firstFK139);
        NINEGRAPH.addVertex(firstFMToilet);
        NINEGRAPH.addVertex(firstFK129);

        NINEGRAPH.addVertex(firstFK127one);
        NINEGRAPH.addVertex(firstFK127two);
        NINEGRAPH.addVertex(firstFK125one);
        NINEGRAPH.addVertex(firstFK125two);
        NINEGRAPH.addVertex(firstFK123one);
        NINEGRAPH.addVertex(firstFK123two);
        NINEGRAPH.addVertex(firstFB121and118);
        NINEGRAPH.addVertex(firstFK121);
        NINEGRAPH.addVertex(firstFK119);
        NINEGRAPH.addVertex(firstFK118Cafeteria);
        NINEGRAPH.addVertex(firstFK116Atwo);
        NINEGRAPH.addVertex(firstFK116Aone);
        NINEGRAPH.addVertex(firstFK116one);
        NINEGRAPH.addVertex(firstFK116two);
        NINEGRAPH.addVertex(firstFK114one);
        NINEGRAPH.addVertex(firstFK114two);
        NINEGRAPH.addVertex(firstFB112and117);
        NINEGRAPH.addVertex(firstFK112);
        NINEGRAPH.addVertex(firstFK117);
        NINEGRAPH.addVertex(firstFK110one);
        NINEGRAPH.addVertex(firstFK110two);
        NINEGRAPH.addVertex(firstFK108one);
        NINEGRAPH.addVertex(firstFK108two);
        NINEGRAPH.addVertex(firstFK115);
        NINEGRAPH.addVertex(firstFK113one);
        NINEGRAPH.addVertex(firstFK113two);
        NINEGRAPH.addVertex(firstFK109A);
        NINEGRAPH.addVertex(firstFK111);
        NINEGRAPH.addVertex(firstFK109);

        NINEGRAPH.addVertex(firstFLeftStairs);
        NINEGRAPH.addVertex(firstFDLeftStairs);
        NINEGRAPH.addVertex(firstFK107);
        NINEGRAPH.addVertex(firstFK105one);
        NINEGRAPH.addVertex(firstFK105two);
        NINEGRAPH.addVertex(firstFK103);
        NINEGRAPH.addVertex(firstFK104);
        NINEGRAPH.addVertex(firstFK106);
        NINEGRAPH.addVertex(firstFB101and102);
        NINEGRAPH.addVertex(firstFK101and100);
        NINEGRAPH.addVertex(firstFK102);

        NINEGRAPH.addConnectionsInTwoSides(firstFLeftStairs, firstFDLeftStairs);
        NINEGRAPH.addConnectionsInTwoSides(firstFLeftStairs, firstFK107);
        NINEGRAPH.addConnectionsInTwoSides(firstFLeftStairs, firstFK105one);
        NINEGRAPH.addConnectionsInTwoSides(firstFK105one, firstFK105two);
        NINEGRAPH.addConnectionsInTwoSides(firstFK105two, firstFK103);
        NINEGRAPH.addConnectionsInTwoSides(firstFK105one, firstFK104);
        NINEGRAPH.addConnectionsInTwoSides(firstFK105one, firstFK106);
        NINEGRAPH.addConnectionsInTwoSides(firstFK105one, firstFB101and102);
        NINEGRAPH.addConnectionsInTwoSides(firstFB101and102, firstFK101and100);
        NINEGRAPH.addConnectionsInTwoSides(firstFB101and102, firstFK102);

        NINEGRAPH.addConnectionsInTwoSides(firstFK109A, firstFDLeftStairs);
        NINEGRAPH.addConnectionsInTwoSides(firstFK109A, firstFK109);
        NINEGRAPH.addConnectionsInTwoSides(firstFK109A, firstFK111);
        NINEGRAPH.addConnectionsInTwoSides(firstFK113one, firstFDLeftStairs);
        NINEGRAPH.addConnectionsInTwoSides(firstFK113one, firstFK113two);
        NINEGRAPH.addConnectionsInTwoSides(firstFK113one, firstFK108one);
        NINEGRAPH.addConnectionsInTwoSides(firstFK108one, firstFK108two);
        NINEGRAPH.addConnectionsInTwoSides(firstFK108one, firstFK115);
        NINEGRAPH.addConnectionsInTwoSides(firstFK108one, firstFK110one);
        NINEGRAPH.addConnectionsInTwoSides(firstFK110one, firstFK110two);
        NINEGRAPH.addConnectionsInTwoSides(firstFK110one, firstFB112and117);
        NINEGRAPH.addConnectionsInTwoSides(firstFK112, firstFB112and117);
        NINEGRAPH.addConnectionsInTwoSides(firstFK117, firstFB112and117);
        NINEGRAPH.addConnectionsInTwoSides(firstFK114one, firstFB112and117);
        NINEGRAPH.addConnectionsInTwoSides(firstFK114one, firstFK114two);
        NINEGRAPH.addConnectionsInTwoSides(firstFK116one, firstFK114one);
        NINEGRAPH.addConnectionsInTwoSides(firstFK116one, firstFK116two);
        NINEGRAPH.addConnectionsInTwoSides(firstFK116one, firstFK116Aone);
        NINEGRAPH.addConnectionsInTwoSides(firstFK116Aone, firstFK116Atwo);
        NINEGRAPH.addConnectionsInTwoSides(firstFK116Aone, firstFB121and118);
        NINEGRAPH.addConnectionsInTwoSides(firstFK121, firstFB121and118);
        NINEGRAPH.addConnectionsInTwoSides(firstFK118Cafeteria, firstFB121and118);
        NINEGRAPH.addConnectionsInTwoSides(firstFK119, firstFK121);
        NINEGRAPH.addConnectionsInTwoSides(firstFK123one, firstFB121and118);
        NINEGRAPH.addConnectionsInTwoSides(firstFK123one, firstFK123two);
        NINEGRAPH.addConnectionsInTwoSides(firstFK123one, firstFK125one);
        NINEGRAPH.addConnectionsInTwoSides(firstFK125one, firstFK125two);
        NINEGRAPH.addConnectionsInTwoSides(firstFK125one, firstFK127one);
        NINEGRAPH.addConnectionsInTwoSides(firstFK127one, firstFK127two);
        NINEGRAPH.addConnectionsInTwoSides(firstFK127one, firstFDRightStairs);
        NINEGRAPH.addConnectionsInTwoSides(firstFDRightStairs, firstFK129);
        NINEGRAPH.addConnectionsInTwoSides(firstFDRightStairs, firstFK131one);
        NINEGRAPH.addConnectionsInTwoSides(firstFK131one, firstFK131two);
        NINEGRAPH.addConnectionsInTwoSides(firstFDRightStairs, firstFRightStairs);
        NINEGRAPH.addConnectionsInTwoSides(firstFRightStairs, firstFK133);
        NINEGRAPH.addConnectionsInTwoSides(firstFRightStairs, firstFB120and135);
        NINEGRAPH.addConnectionsInTwoSides(firstFB120and135, firstFK120);
        NINEGRAPH.addConnectionsInTwoSides(firstFB120and135, firstFK135);
        NINEGRAPH.addConnectionsInTwoSides(firstFB120Aand137, firstFB120and135);
        NINEGRAPH.addConnectionsInTwoSides(firstFB120Aand137, firstFK120a);
        NINEGRAPH.addConnectionsInTwoSides(firstFB120Aand137, firstFK137);
        NINEGRAPH.addConnectionsInTwoSides(firstFB101and139, firstFB120Aand137);
        NINEGRAPH.addConnectionsInTwoSides(firstFB101and139, firstFK101);
        NINEGRAPH.addConnectionsInTwoSides(firstFB101and139, firstFK139);
        NINEGRAPH.addConnectionsInTwoSides(firstFB101and139, firstFMToilet);


        Vertex secondFRightStairs = new Vertex("правая лестница", new Point(616, 322), 2);
        Vertex secondFK233 = new Vertex("233", new Point(638, 322), 1);
        Vertex secondFDRightStairs = new Vertex("ниже правой лестницы", new Point(616, 346), 2);
        Vertex secondFK231one = new Vertex("231 подход", new Point(670, 346), 2);
        Vertex secondFK231two = new Vertex("231", new Point(670, 369), 2);
        Vertex secondFK229 = new Vertex("229", new Point(646, 369), 2);
        Vertex secondFK235one = new Vertex("подход 235", new Point(616, 281), 2);
        Vertex secondFK235two = new Vertex("235", new Point(638, 281), 2);
        Vertex secondFB216and237and239 = new Vertex("между 216,237 и 239", new Point(616, 205), 2);
        Vertex secondFK237 = new Vertex("237", new Point(636, 220), 2);
        Vertex secondFK239 = new Vertex("239", new Point(636, 182), 2);
        Vertex secondFK216 = new Vertex("216", new Point(593, 199), 2);
        Vertex secondFBWCand243and241 = new Vertex("между WC,243 и 241", new Point(616, 147), 2);
        Vertex secondFK241 = new Vertex("241", new Point(636, 163), 2);
        Vertex secondFK243 = new Vertex("243", new Point(636, 131), 2);
        Vertex secondFWC = new Vertex("WC", new Point(593, 131), 2);
        Vertex secondFK227 = new Vertex("227", new Point(613, 369), 2);

        Vertex secondFK225one = new Vertex("225 подход", new Point(576, 346), 2);
        Vertex secondFK225two = new Vertex("225", new Point(576, 369), 2);
        Vertex secondFK223one = new Vertex("223 подход", new Point(544, 346), 2);
        Vertex secondFK223two = new Vertex("223", new Point(544, 369), 2);
        Vertex secondFK221one = new Vertex("221 подход", new Point(518, 346), 2);
        Vertex secondFK221two = new Vertex("221", new Point(518, 369), 2);
        Vertex secondFK214 = new Vertex("214", new Point(518, 328), 2);
        Vertex secondFK212one = new Vertex("212 подход", new Point(495, 346), 2);
        Vertex secondFK212two = new Vertex("212", new Point(495, 328), 2);
        Vertex secondFK219one = new Vertex("219 подход", new Point(406, 346), 2);
        Vertex secondFK219two = new Vertex("219", new Point(406, 369), 2);
        Vertex secondFK210one = new Vertex("210 подход", new Point(356, 346), 2);
        Vertex secondFK210two = new Vertex("210", new Point(356, 328), 2);
        Vertex secondFK217one = new Vertex("217 подход", new Point(309, 346), 2);
        Vertex secondFK217two = new Vertex("217", new Point(309, 369), 2);
        Vertex secondFK208 = new Vertex("208", new Point(284, 328), 2);
        Vertex secondFK215one = new Vertex("215 подход", new Point(250, 346), 2);
        Vertex secondFK215two = new Vertex("215", new Point(250, 369), 2);
        Vertex secondFK213one = new Vertex("213 подход", new Point(148, 346), 2);
        Vertex secondFK213two = new Vertex("213", new Point(148, 369), 2);

        Vertex secondFLeftStairs = new Vertex("левая лестница", new Point(104, 318), 2);
        Vertex secondFK209 = new Vertex("209", new Point(86, 318), 2);
        Vertex secondFK211one = new Vertex("подход 211", new Point(104, 346), 2);
        Vertex secondFK211two = new Vertex("211", new Point(112, 369), 2);
        Vertex secondFB207and206 = new Vertex("между 207 и 206", new Point(104, 283), 2);
        Vertex secondFK207 = new Vertex("207", new Point(86, 283), 2);
        Vertex secondFK206 = new Vertex("206", new Point(118, 283), 2);
        Vertex secondFB205and204 = new Vertex("между 205 и 204", new Point(104, 258), 2);
        Vertex secondFK205 = new Vertex("205", new Point(86, 258), 2);
        Vertex secondFK204 = new Vertex("204", new Point(118, 258), 2);
        Vertex secondFB201and202 = new Vertex("между 201 и 202", new Point(104, 144), 2);
        Vertex secondFK201 = new Vertex("205", new Point(86, 125), 2);
        Vertex secondFWToilet = new Vertex("204", new Point(118, 125), 2);
        Vertex secondFK203 = new Vertex("205", new Point(86, 162), 2);
        Vertex secondFK202 = new Vertex("204", new Point(118, 162), 2);


        NINEGRAPH.addVertex(secondFRightStairs);
        NINEGRAPH.addVertex(secondFK233);
        NINEGRAPH.addVertex(secondFDRightStairs);
        NINEGRAPH.addVertex(secondFK231one);
        NINEGRAPH.addVertex(secondFK231two);
        NINEGRAPH.addVertex(secondFK229);
        NINEGRAPH.addVertex(secondFK235one);
        NINEGRAPH.addVertex(secondFK235two);
        NINEGRAPH.addVertex(secondFB216and237and239);
        NINEGRAPH.addVertex(secondFK237);
        NINEGRAPH.addVertex(secondFK239);
        NINEGRAPH.addVertex(secondFK216);
        NINEGRAPH.addVertex(secondFBWCand243and241);
        NINEGRAPH.addVertex(secondFK241);
        NINEGRAPH.addVertex(secondFK243);
        NINEGRAPH.addVertex(secondFWC);
        NINEGRAPH.addVertex(secondFK227);

        NINEGRAPH.addVertex(secondFK225one);
        NINEGRAPH.addVertex(secondFK225two);
        NINEGRAPH.addVertex(secondFK223one);
        NINEGRAPH.addVertex(secondFK223two);
        NINEGRAPH.addVertex(secondFK221one);
        NINEGRAPH.addVertex(secondFK221two);
        NINEGRAPH.addVertex(secondFK214);
        NINEGRAPH.addVertex(secondFK212one);
        NINEGRAPH.addVertex(secondFK212two);
        NINEGRAPH.addVertex(secondFK219one);
        NINEGRAPH.addVertex(secondFK219two);
        NINEGRAPH.addVertex(secondFK210one);
        NINEGRAPH.addVertex(secondFK210two);
        NINEGRAPH.addVertex(secondFK217one);
        NINEGRAPH.addVertex(secondFK217two);
        NINEGRAPH.addVertex(secondFK208);
        NINEGRAPH.addVertex(secondFK215one);
        NINEGRAPH.addVertex(secondFK215two);
        NINEGRAPH.addVertex(secondFK213one);
        NINEGRAPH.addVertex(secondFK213two);

        NINEGRAPH.addVertex(secondFLeftStairs);
        NINEGRAPH.addVertex(secondFK209);
        NINEGRAPH.addVertex(secondFK211one);
        NINEGRAPH.addVertex(secondFK211two);
        NINEGRAPH.addVertex(secondFB207and206);
        NINEGRAPH.addVertex(secondFK207);
        NINEGRAPH.addVertex(secondFK206);
        NINEGRAPH.addVertex(secondFB205and204);
        NINEGRAPH.addVertex(secondFK205);
        NINEGRAPH.addVertex(secondFK204);
        NINEGRAPH.addVertex(secondFB201and202);
        NINEGRAPH.addVertex(secondFK201);
        NINEGRAPH.addVertex(secondFWToilet);
        NINEGRAPH.addVertex(secondFK203);
        NINEGRAPH.addVertex(secondFK202);

        NINEGRAPH.addConnectionsInTwoSides(secondFLeftStairs, secondFK211one);
        NINEGRAPH.addConnectionsInTwoSides(secondFLeftStairs, secondFK209);
        NINEGRAPH.addConnectionsInTwoSides(secondFK211one, secondFK211two);
        NINEGRAPH.addConnectionsInTwoSides(secondFB207and206, secondFK211one);
        NINEGRAPH.addConnectionsInTwoSides(secondFB207and206, secondFK207);
        NINEGRAPH.addConnectionsInTwoSides(secondFB207and206, secondFK206);
        NINEGRAPH.addConnectionsInTwoSides(secondFB205and204, secondFB207and206);
        NINEGRAPH.addConnectionsInTwoSides(secondFB205and204, secondFK205);
        NINEGRAPH.addConnectionsInTwoSides(secondFB205and204, secondFK204);
        NINEGRAPH.addConnectionsInTwoSides(secondFB201and202, secondFB205and204);
        NINEGRAPH.addConnectionsInTwoSides(secondFB201and202, secondFK201);
        NINEGRAPH.addConnectionsInTwoSides(secondFB201and202, secondFK203);
        NINEGRAPH.addConnectionsInTwoSides(secondFB201and202, secondFK202);
        NINEGRAPH.addConnectionsInTwoSides(secondFB201and202, secondFWToilet);

        NINEGRAPH.addConnectionsInTwoSides(secondFK213one, secondFK211one);
        NINEGRAPH.addConnectionsInTwoSides(secondFK213one, secondFK213two);
        NINEGRAPH.addConnectionsInTwoSides(secondFK215one, secondFK213one);
        NINEGRAPH.addConnectionsInTwoSides(secondFK215two, secondFK215one);
        NINEGRAPH.addConnectionsInTwoSides(secondFK215one, secondFK208);
        NINEGRAPH.addConnectionsInTwoSides(secondFK217one, secondFK215one);
        NINEGRAPH.addConnectionsInTwoSides(secondFK217one, secondFK217two);
        NINEGRAPH.addConnectionsInTwoSides(secondFK217one, secondFK210one);
        NINEGRAPH.addConnectionsInTwoSides(secondFK210two, secondFK210one);
        NINEGRAPH.addConnectionsInTwoSides(secondFK219one, secondFK210one);
        NINEGRAPH.addConnectionsInTwoSides(secondFK219one, secondFK219two);
        NINEGRAPH.addConnectionsInTwoSides(secondFK219one, secondFK212one);
        NINEGRAPH.addConnectionsInTwoSides(secondFK212one, secondFK212two);
        NINEGRAPH.addConnectionsInTwoSides(secondFK212one, secondFK221one);
        NINEGRAPH.addConnectionsInTwoSides(secondFK221one, secondFK221two);
        NINEGRAPH.addConnectionsInTwoSides(secondFK221one, secondFK214);
        NINEGRAPH.addConnectionsInTwoSides(secondFK221one, secondFK223one);
        NINEGRAPH.addConnectionsInTwoSides(secondFK223one, secondFK223two);
        NINEGRAPH.addConnectionsInTwoSides(secondFK223one, secondFK225one);
        NINEGRAPH.addConnectionsInTwoSides(secondFK225one, secondFK225two);

        NINEGRAPH.addConnectionsInTwoSides(secondFK225one, secondFDRightStairs);
        NINEGRAPH.addConnectionsInTwoSides(secondFDRightStairs, secondFK227);
        NINEGRAPH.addConnectionsInTwoSides(secondFDRightStairs, secondFK231one);
        NINEGRAPH.addConnectionsInTwoSides(secondFK231two, secondFK231one);
        NINEGRAPH.addConnectionsInTwoSides(secondFK229, secondFK231one);
        NINEGRAPH.addConnectionsInTwoSides(secondFRightStairs, secondFDRightStairs);
        NINEGRAPH.addConnectionsInTwoSides(secondFRightStairs, secondFK233);
        NINEGRAPH.addConnectionsInTwoSides(secondFRightStairs, secondFK235one);
        NINEGRAPH.addConnectionsInTwoSides(secondFK235two, secondFK235one);
        NINEGRAPH.addConnectionsInTwoSides(secondFK235one, secondFB216and237and239);
        NINEGRAPH.addConnectionsInTwoSides(secondFK237, secondFB216and237and239);
        NINEGRAPH.addConnectionsInTwoSides(secondFK239, secondFB216and237and239);
        NINEGRAPH.addConnectionsInTwoSides(secondFK216, secondFB216and237and239);
        NINEGRAPH.addConnectionsInTwoSides(secondFB216and237and239, secondFBWCand243and241);
        NINEGRAPH.addConnectionsInTwoSides(secondFWC, secondFBWCand243and241);
        NINEGRAPH.addConnectionsInTwoSides(secondFK241, secondFBWCand243and241);
        NINEGRAPH.addConnectionsInTwoSides(secondFK243, secondFBWCand243and241);

        Vertex thirdFRightStairs = new Vertex("правая лестница", new Point(634, 314), 3);
        Vertex thirdFK327 = new Vertex("327", new Point(654, 314), 3);
        Vertex thirdFDRightStairs = new Vertex("ниже правой лестницы", new Point(627, 334), 3);
        Vertex thirdFK325 = new Vertex("325", new Point(627, 361), 3);
        Vertex thirdFB326and329 = new Vertex("между 326 и 329", new Point(634, 281), 3);
        Vertex thirdFK326 = new Vertex("подход 326", new Point(616, 284), 3);
        Vertex thirdFK329 = new Vertex("подход 329", new Point(654, 275), 3);
        Vertex thirdFB328and331 = new Vertex("между 328 и 331", new Point(634, 249), 3);
        Vertex thirdFK328 = new Vertex("328", new Point(616, 244), 3);
        Vertex thirdFK331 = new Vertex("331", new Point(654, 247), 3);
        Vertex thirdFB332and330and333 = new Vertex("между 332,330 и 333", new Point(634, 196), 3);
        Vertex thirdFK332 = new Vertex("332", new Point(616, 189), 3);
        Vertex thirdFK330 = new Vertex("330", new Point(616, 215), 3);
        Vertex thirdFK333 = new Vertex("333", new Point(654, 215), 3);
        Vertex thirdFB334and335andWToilet = new Vertex("между 334,335 и WToilet", new Point(634, 145), 3);
        Vertex thirdFK334 = new Vertex("334", new Point(616, 146), 3);
        Vertex thirdFK335 = new Vertex("335", new Point(654, 257), 3);
        Vertex thirdFWToilet = new Vertex("WToilet", new Point(616, 124), 3);

        Vertex thirdFB324and323 = new Vertex("между 324 и 323", new Point(536, 334), 3);
        Vertex thirdFK323 = new Vertex("323", new Point(536, 361), 3);
        Vertex thirdFK324 = new Vertex("324", new Point(536, 318), 3);
        Vertex thirdFB322and321and320 = new Vertex("между 322,321 и 320", new Point(474, 334), 3);
        Vertex thirdFK322 = new Vertex("322", new Point(487, 318), 3);
        Vertex thirdFK321 = new Vertex("321", new Point(474, 361), 3);
        Vertex thirdFK320 = new Vertex("320", new Point(454, 318), 3);
        Vertex thirdFB319and318and317 = new Vertex("между 319,318 и 317", new Point(416, 334), 3);
        Vertex thirdFK319 = new Vertex("319", new Point(427, 361), 3);
        Vertex thirdFK318 = new Vertex("318", new Point(427, 318), 3);
        Vertex thirdFK317 = new Vertex("317", new Point(396, 361), 3);
        Vertex thirdFK316one = new Vertex("316 подход", new Point(364, 334), 3);
        Vertex thirdFK316two = new Vertex("316", new Point(364, 318), 3);
        Vertex thirdFB314and315and312 = new Vertex("между 314,315 и 312", new Point(324, 334), 3);
        Vertex thirdFK314 = new Vertex("314", new Point(332, 318), 3);
        Vertex thirdFK315 = new Vertex("315", new Point(332, 361), 3);
        Vertex thirdFK312 = new Vertex("312", new Point(298, 318), 3);
        Vertex thirdFB310and313and308 = new Vertex("между 310,313 и 308", new Point(260, 334), 3);
        Vertex thirdFK310 = new Vertex("310", new Point(260, 318), 3);
        Vertex thirdFK313 = new Vertex("313", new Point(260, 361), 3);
        Vertex thirdFK308 = new Vertex("308", new Point(232, 318), 3);
        Vertex thirdFK311one = new Vertex("подход 311", new Point(201, 334), 3);
        Vertex thirdFK311two = new Vertex("311", new Point(201, 361), 3);
        Vertex thirdFLeftStairs = new Vertex("левая лестница", new Point(123, 311), 3);
        Vertex thirdFK309one = new Vertex("подход 309", new Point(123, 331), 3);
        Vertex thirdFK309two = new Vertex("309", new Point(131, 361), 3);
        Vertex thirdFK307 = new Vertex("307", new Point(104, 311), 3);
        Vertex thirdFK306one = new Vertex("подход 306", new Point(123, 273), 3);
        Vertex thirdFK306two = new Vertex("306", new Point(138, 273), 3);
        Vertex thirdFB305and304 = new Vertex("между 305 и 304", new Point(123, 248), 3);
        Vertex thirdFK305 = new Vertex("305", new Point(104, 248), 3);
        Vertex thirdFK304 = new Vertex("304", new Point(138, 248), 3);
        Vertex thirdFK303one = new Vertex("подход 303", new Point(123, 191), 3);
        Vertex thirdFK303two = new Vertex("303", new Point(104, 191), 3);
        Vertex thirdFB301and302andMToilet = new Vertex("между 301,302 и MToilet", new Point(123, 158), 3);
        Vertex thirdFK301 = new Vertex("205", new Point(104, 158), 3);
        Vertex thirdFMToilet = new Vertex("204", new Point(138, 123), 3);
        Vertex thirdFK302 = new Vertex("205", new Point(138, 158), 3);


        NINEGRAPH.addVertex(thirdFRightStairs);
        NINEGRAPH.addVertex(thirdFK327);
        NINEGRAPH.addVertex(thirdFDRightStairs);
        NINEGRAPH.addVertex(thirdFK325);
        NINEGRAPH.addVertex(thirdFB326and329);
        NINEGRAPH.addVertex(thirdFK326);
        NINEGRAPH.addVertex(thirdFK329);
        NINEGRAPH.addVertex(thirdFB328and331);
        NINEGRAPH.addVertex(thirdFK328);
        NINEGRAPH.addVertex(thirdFK331);
        NINEGRAPH.addVertex(thirdFB332and330and333);
        NINEGRAPH.addVertex(thirdFK332);
        NINEGRAPH.addVertex(thirdFK330);
        NINEGRAPH.addVertex(thirdFK333);
        NINEGRAPH.addVertex(thirdFB334and335andWToilet);
        NINEGRAPH.addVertex(thirdFK334);
        NINEGRAPH.addVertex(thirdFK335);
        NINEGRAPH.addVertex(thirdFWToilet);

        NINEGRAPH.addVertex(thirdFB324and323);
        NINEGRAPH.addVertex(thirdFK323);
        NINEGRAPH.addVertex(thirdFK324);
        NINEGRAPH.addVertex(thirdFB322and321and320);
        NINEGRAPH.addVertex(thirdFK322);
        NINEGRAPH.addVertex(thirdFK321);
        NINEGRAPH.addVertex(thirdFK320);
        NINEGRAPH.addVertex(thirdFB319and318and317);
        NINEGRAPH.addVertex(thirdFK319);
        NINEGRAPH.addVertex(thirdFK318);
        NINEGRAPH.addVertex(thirdFK317);
        NINEGRAPH.addVertex(thirdFK316one);
        NINEGRAPH.addVertex(thirdFK316two);
        NINEGRAPH.addVertex(thirdFB314and315and312);
        NINEGRAPH.addVertex(thirdFK314);
        NINEGRAPH.addVertex(thirdFK315);
        NINEGRAPH.addVertex(thirdFK312);
        NINEGRAPH.addVertex(thirdFB310and313and308);
        NINEGRAPH.addVertex(thirdFK310);
        NINEGRAPH.addVertex(thirdFK313);
        NINEGRAPH.addVertex(thirdFK308);
        NINEGRAPH.addVertex(thirdFK311one);
        NINEGRAPH.addVertex(thirdFK311two);

        NINEGRAPH.addVertex(thirdFLeftStairs);
        NINEGRAPH.addVertex(thirdFK309one);
        NINEGRAPH.addVertex(thirdFK309two);
        NINEGRAPH.addVertex(thirdFK307);
        NINEGRAPH.addVertex(thirdFK306one);
        NINEGRAPH.addVertex(thirdFK306two);
        NINEGRAPH.addVertex(thirdFB305and304);
        NINEGRAPH.addVertex(thirdFK305);
        NINEGRAPH.addVertex(thirdFK304);
        NINEGRAPH.addVertex(thirdFK303one);
        NINEGRAPH.addVertex(thirdFK303two);
        NINEGRAPH.addVertex(thirdFB301and302andMToilet);
        NINEGRAPH.addVertex(thirdFK301);
        NINEGRAPH.addVertex(thirdFMToilet);
        NINEGRAPH.addVertex(thirdFK302);

        NINEGRAPH.addConnectionsInTwoSides(thirdFLeftStairs, thirdFK309one);
        NINEGRAPH.addConnectionsInTwoSides(thirdFK309one, thirdFK309two);
        NINEGRAPH.addConnectionsInTwoSides(thirdFLeftStairs, thirdFK307);
        NINEGRAPH.addConnectionsInTwoSides(thirdFLeftStairs, thirdFK306one);
        NINEGRAPH.addConnectionsInTwoSides(thirdFK306two, thirdFK306one);
        NINEGRAPH.addConnectionsInTwoSides(thirdFB305and304, thirdFK306one);
        NINEGRAPH.addConnectionsInTwoSides(thirdFB305and304, thirdFK305);
        NINEGRAPH.addConnectionsInTwoSides(thirdFB305and304, thirdFK304);
        NINEGRAPH.addConnectionsInTwoSides(thirdFB305and304, thirdFK303one);
        NINEGRAPH.addConnectionsInTwoSides(thirdFK303one, thirdFK303two);
        NINEGRAPH.addConnectionsInTwoSides(thirdFK303one, thirdFB301and302andMToilet);
        NINEGRAPH.addConnectionsInTwoSides(thirdFB301and302andMToilet, thirdFK301);
        NINEGRAPH.addConnectionsInTwoSides(thirdFB301and302andMToilet, thirdFK302);
        NINEGRAPH.addConnectionsInTwoSides(thirdFB301and302andMToilet, thirdFMToilet);

        NINEGRAPH.addConnectionsInTwoSides(thirdFK309one, thirdFK311one);
        NINEGRAPH.addConnectionsInTwoSides(thirdFK311one, thirdFK311two);
        NINEGRAPH.addConnectionsInTwoSides(thirdFK311one, thirdFB310and313and308);
        NINEGRAPH.addConnectionsInTwoSides(thirdFB310and313and308, thirdFK310);
        NINEGRAPH.addConnectionsInTwoSides(thirdFB310and313and308, thirdFK313);
        NINEGRAPH.addConnectionsInTwoSides(thirdFB310and313and308, thirdFK308);
        NINEGRAPH.addConnectionsInTwoSides(thirdFB310and313and308, thirdFB314and315and312);
        NINEGRAPH.addConnectionsInTwoSides(thirdFB314and315and312, thirdFK314);
        NINEGRAPH.addConnectionsInTwoSides(thirdFB314and315and312, thirdFK315);
        NINEGRAPH.addConnectionsInTwoSides(thirdFB314and315and312, thirdFK312);
        NINEGRAPH.addConnectionsInTwoSides(thirdFB314and315and312, thirdFK316one);
        NINEGRAPH.addConnectionsInTwoSides(thirdFK316one, thirdFK316two);
        NINEGRAPH.addConnectionsInTwoSides(thirdFK316one, thirdFB319and318and317);
        NINEGRAPH.addConnectionsInTwoSides(thirdFB319and318and317, thirdFK317);
        NINEGRAPH.addConnectionsInTwoSides(thirdFB319and318and317, thirdFK318);
        NINEGRAPH.addConnectionsInTwoSides(thirdFB319and318and317, thirdFK319);
        NINEGRAPH.addConnectionsInTwoSides(thirdFB319and318and317, thirdFB322and321and320);
        NINEGRAPH.addConnectionsInTwoSides(thirdFB322and321and320, thirdFK320);
        NINEGRAPH.addConnectionsInTwoSides(thirdFB322and321and320, thirdFK321);
        NINEGRAPH.addConnectionsInTwoSides(thirdFB322and321and320, thirdFK322);
        NINEGRAPH.addConnectionsInTwoSides(thirdFB322and321and320, thirdFB324and323);
        NINEGRAPH.addConnectionsInTwoSides(thirdFK323, thirdFB324and323);
        NINEGRAPH.addConnectionsInTwoSides(thirdFK324, thirdFB324and323);
        NINEGRAPH.addConnectionsInTwoSides(thirdFDRightStairs, thirdFB324and323);


        NINEGRAPH.addConnectionsInTwoSides(thirdFDRightStairs, thirdFK325);
        NINEGRAPH.addConnectionsInTwoSides(thirdFDRightStairs, thirdFRightStairs);
        NINEGRAPH.addConnectionsInTwoSides(thirdFRightStairs, thirdFK327);
        NINEGRAPH.addConnectionsInTwoSides(thirdFRightStairs, thirdFB326and329);
        NINEGRAPH.addConnectionsInTwoSides(thirdFB326and329, thirdFK326);
        NINEGRAPH.addConnectionsInTwoSides(thirdFB326and329, thirdFK329);
        NINEGRAPH.addConnectionsInTwoSides(thirdFB326and329, thirdFB328and331);
        NINEGRAPH.addConnectionsInTwoSides(thirdFB328and331, thirdFK328);
        NINEGRAPH.addConnectionsInTwoSides(thirdFB328and331, thirdFK331);
        NINEGRAPH.addConnectionsInTwoSides(thirdFB328and331, thirdFB332and330and333);
        NINEGRAPH.addConnectionsInTwoSides(thirdFB332and330and333, thirdFK332);
        NINEGRAPH.addConnectionsInTwoSides(thirdFB332and330and333, thirdFK330);
        NINEGRAPH.addConnectionsInTwoSides(thirdFB332and330and333, thirdFK333);
        NINEGRAPH.addConnectionsInTwoSides(thirdFB332and330and333, thirdFB334and335andWToilet);
        NINEGRAPH.addConnectionsInTwoSides(thirdFB334and335andWToilet, thirdFWToilet);
        NINEGRAPH.addConnectionsInTwoSides(thirdFB334and335andWToilet, thirdFK335);
        NINEGRAPH.addConnectionsInTwoSides(thirdFB334and335andWToilet, thirdFK334);


        Vertex fourthFRightStairs = new Vertex("правая лестница", new Point(624, 324), 4);
        Vertex fourthFK433 = new Vertex("433", new Point(643, 324), 4);
        Vertex fourthFDRightStairs = new Vertex("ниже правой лестницы", new Point(624, 344), 4);
        Vertex fourthFK429 = new Vertex("429", new Point(612, 370), 4);
        Vertex fourthFK431one = new Vertex("подход 431", new Point(648, 344), 4);
        Vertex fourthFK431two = new Vertex("431", new Point(648, 370), 4);
        Vertex fourthFK431Aone = new Vertex("подход 431a", new Point(674, 344), 4);
        Vertex fourthFK431Atwo = new Vertex("431a", new Point(674, 370), 4);
        Vertex fourthFB435and437 = new Vertex("между 435 и 437", new Point(624, 249), 4);
        Vertex fourthFK435 = new Vertex("435", new Point(643, 249), 4);
        Vertex fourthFK437 = new Vertex("437", new Point(643, 220), 4);
        Vertex fourthFB432and439 = new Vertex("между 432 и 439", new Point(624, 198), 4);
        Vertex fourthFK432 = new Vertex("432", new Point(607, 198), 4);
        Vertex fourthFK439 = new Vertex("439", new Point(643, 184), 4);
        Vertex fourthFB434and441andWC = new Vertex("между 434,441 и WC", new Point(624, 159), 4);
        Vertex fourthFK434 = new Vertex("434", new Point(607, 156), 4);
        Vertex fourthFK441 = new Vertex("441", new Point(643, 164), 4);
        Vertex fourthFWC = new Vertex("WToilet", new Point(607, 127), 4);

        Vertex fourthFK427one = new Vertex("подход 427", new Point(576, 344), 4);
        Vertex fourthFK427two = new Vertex("427", new Point(576, 370), 4);
        Vertex fourthFK425 = new Vertex("425", new Point(523, 370), 4);
        Vertex fourthFB430and423and428 = new Vertex("между 430,423 и 428", new Point(509, 344), 4);
        Vertex fourthFK430 = new Vertex("430", new Point(520, 329), 4);
        Vertex fourthFK423 = new Vertex("423", new Point(494, 370), 4);
        Vertex fourthFK428 = new Vertex("428", new Point(494, 329), 4);
        Vertex fourthFB421and426 = new Vertex("между 421 и 426", new Point(463, 344), 4);
        Vertex fourthFK421 = new Vertex("421", new Point(458, 370), 4);
        Vertex fourthFK426 = new Vertex("426", new Point(467, 329), 4);
        Vertex fourthFB424and422 = new Vertex("между 424 и 422", new Point(427, 344), 4);
        Vertex fourthFK424 = new Vertex("424", new Point(439, 329), 4);
        Vertex fourthFK422 = new Vertex("422", new Point(411, 329), 4);
        Vertex fourthFK419one = new Vertex("подход 419", new Point(376, 344), 4);
        Vertex fourthFK419two = new Vertex("419", new Point(376, 370), 4);
        Vertex fourthFB420and417A = new Vertex("между 420 и 417A", new Point(348, 344), 4);
        Vertex fourthFK417A = new Vertex("417a", new Point(348, 370), 4);
        Vertex fourthFK420 = new Vertex("420", new Point(348, 329), 4);
        Vertex fourthFB417and418 = new Vertex("между 417 и 418", new Point(313, 344), 4);
        Vertex fourthFK417 = new Vertex("417", new Point(313, 370), 4);
        Vertex fourthFK418 = new Vertex("418", new Point(313, 329), 4);
        Vertex fourthFB414and415 = new Vertex("между 414 и 415", new Point(247, 344), 4);
        Vertex fourthFK414 = new Vertex("414", new Point(247, 329), 4);
        Vertex fourthFK415 = new Vertex("415", new Point(247, 370), 4);
        Vertex fourthFK416 = new Vertex("416", new Point(265, 329), 4);
        Vertex fourthFK412one = new Vertex("подход 412", new Point(208, 344), 4);
        Vertex fourthFK412two = new Vertex("412", new Point(208, 329), 4);
        Vertex fourthFK413one = new Vertex("подход 413", new Point(153, 344), 4);
        Vertex fourthFK413two = new Vertex("413", new Point(153, 329), 4);

        Vertex fourthFLeftStairs = new Vertex("левая лестница", new Point(109, 320), 4);
        Vertex fourthFK411one = new Vertex("подход 411", new Point(106, 344), 4);
        Vertex fourthFK411two = new Vertex("411", new Point(115, 370), 4);
        Vertex fourthFK409one = new Vertex("подход 409", new Point(57, 344), 4);
        Vertex fourthFK409two = new Vertex("409", new Point(57, 370), 4);
        Vertex fourthFK407 = new Vertex("407", new Point(90, 320), 4);
        Vertex fourthFB405Aand410 = new Vertex("между 405a и 410", new Point(106, 284), 4);
        Vertex fourthFK405A = new Vertex("405a", new Point(90, 284), 4);
        Vertex fourthFK410 = new Vertex("410", new Point(124, 284), 4);
        Vertex fourthFK408 = new Vertex("408", new Point(124, 258), 4);
        Vertex fourthFB405and404 = new Vertex("между 405 и 404", new Point(106, 205), 4);
        Vertex fourthFK405 = new Vertex("205", new Point(124, 205), 4);
        Vertex fourthFK404 = new Vertex("204", new Point(90, 205), 4);
        Vertex fourthFB403and402 = new Vertex("между 403 и 402", new Point(106, 165), 4);
        Vertex fourthFK403 = new Vertex("403", new Point(124, 165), 4);
        Vertex fourthFK402 = new Vertex("402", new Point(90, 165), 4);
        Vertex fourthFB401andWToilet = new Vertex("между 401 и WToilet", new Point(106, 128), 4);
        Vertex fourthFK401 = new Vertex("401", new Point(124, 128), 4);
        Vertex fourthFWToilet = new Vertex("WToilet", new Point(90, 128), 4);


        NINEGRAPH.addVertex(fourthFRightStairs);
        NINEGRAPH.addVertex(fourthFK433);
        NINEGRAPH.addVertex(fourthFDRightStairs);
        NINEGRAPH.addVertex(fourthFK429);
        NINEGRAPH.addVertex(fourthFK431one);
        NINEGRAPH.addVertex(fourthFK431two);
        NINEGRAPH.addVertex(fourthFK431Aone);
        NINEGRAPH.addVertex(fourthFK431Atwo);
        NINEGRAPH.addVertex(fourthFB435and437);
        NINEGRAPH.addVertex(fourthFK435);
        NINEGRAPH.addVertex(fourthFK437);
        NINEGRAPH.addVertex(fourthFB432and439);
        NINEGRAPH.addVertex(fourthFK432);
        NINEGRAPH.addVertex(fourthFK439);
        NINEGRAPH.addVertex(fourthFB434and441andWC);
        NINEGRAPH.addVertex(fourthFK434);
        NINEGRAPH.addVertex(fourthFK441);
        NINEGRAPH.addVertex(fourthFWC);

        NINEGRAPH.addVertex(fourthFK427one);
        NINEGRAPH.addVertex(fourthFK427two);
        NINEGRAPH.addVertex(fourthFK425);
        NINEGRAPH.addVertex(fourthFB430and423and428);
        NINEGRAPH.addVertex(fourthFK430);
        NINEGRAPH.addVertex(fourthFK423);
        NINEGRAPH.addVertex(fourthFK428);
        NINEGRAPH.addVertex(fourthFB421and426);
        NINEGRAPH.addVertex(fourthFK421);
        NINEGRAPH.addVertex(fourthFK426);
        NINEGRAPH.addVertex(fourthFB424and422);
        NINEGRAPH.addVertex(fourthFK424);
        NINEGRAPH.addVertex(fourthFK422);
        NINEGRAPH.addVertex(fourthFK419one);
        NINEGRAPH.addVertex(fourthFK419two);
        NINEGRAPH.addVertex(fourthFB420and417A);
        NINEGRAPH.addVertex(fourthFK417A);
        NINEGRAPH.addVertex(fourthFK420);
        NINEGRAPH.addVertex(fourthFB417and418);
        NINEGRAPH.addVertex(fourthFK417);
        NINEGRAPH.addVertex(fourthFK418);
        NINEGRAPH.addVertex(fourthFB414and415);
        NINEGRAPH.addVertex(fourthFK414);
        NINEGRAPH.addVertex(fourthFK415);
        NINEGRAPH.addVertex(fourthFK416);
        NINEGRAPH.addVertex(fourthFK412one);
        NINEGRAPH.addVertex(fourthFK412two);
        NINEGRAPH.addVertex(fourthFK413one);
        NINEGRAPH.addVertex(fourthFK413two);

        NINEGRAPH.addVertex(fourthFLeftStairs);
        NINEGRAPH.addVertex(fourthFK411one);
        NINEGRAPH.addVertex(fourthFK411two);
        NINEGRAPH.addVertex(fourthFK409one);
        NINEGRAPH.addVertex(fourthFK409two);
        NINEGRAPH.addVertex(fourthFK407);
        NINEGRAPH.addVertex(fourthFB405Aand410);
        NINEGRAPH.addVertex(fourthFK405A);
        NINEGRAPH.addVertex(fourthFK408);
        NINEGRAPH.addVertex(fourthFK410);
        NINEGRAPH.addVertex(fourthFB405and404);
        NINEGRAPH.addVertex(fourthFK405);
        NINEGRAPH.addVertex(fourthFK404);
        NINEGRAPH.addVertex(fourthFB403and402);
        NINEGRAPH.addVertex(fourthFK403);
        NINEGRAPH.addVertex(fourthFK402);
        NINEGRAPH.addVertex(fourthFB401andWToilet);
        NINEGRAPH.addVertex(fourthFK401);
        NINEGRAPH.addVertex(fourthFWToilet);

        NINEGRAPH.addConnectionsInTwoSides(fourthFLeftStairs, fourthFK411one);
        NINEGRAPH.addConnectionsInTwoSides(fourthFK411two, fourthFK411one);
        NINEGRAPH.addConnectionsInTwoSides(fourthFK411one, fourthFK409one);
        NINEGRAPH.addConnectionsInTwoSides(fourthFK409one, fourthFK409two);
        NINEGRAPH.addConnectionsInTwoSides(fourthFK411one, fourthFLeftStairs);
        NINEGRAPH.addConnectionsInTwoSides(fourthFLeftStairs, fourthFK407);
        NINEGRAPH.addConnectionsInTwoSides(fourthFLeftStairs, fourthFB405Aand410);
        NINEGRAPH.addConnectionsInTwoSides(fourthFB405Aand410, fourthFK405A);
        NINEGRAPH.addConnectionsInTwoSides(fourthFB405Aand410, fourthFK410);
        NINEGRAPH.addConnectionsInTwoSides(fourthFB405Aand410, fourthFK408);
        NINEGRAPH.addConnectionsInTwoSides(fourthFB405Aand410, fourthFB405and404);
        NINEGRAPH.addConnectionsInTwoSides(fourthFB405and404, fourthFK405);
        NINEGRAPH.addConnectionsInTwoSides(fourthFB405and404, fourthFK404);
        NINEGRAPH.addConnectionsInTwoSides(fourthFB405and404, fourthFB403and402);
        NINEGRAPH.addConnectionsInTwoSides(fourthFK403, fourthFB403and402);
        NINEGRAPH.addConnectionsInTwoSides(fourthFK402, fourthFB403and402);
        NINEGRAPH.addConnectionsInTwoSides(fourthFB401andWToilet, fourthFB403and402);
        NINEGRAPH.addConnectionsInTwoSides(fourthFB401andWToilet, fourthFK401);
        NINEGRAPH.addConnectionsInTwoSides(fourthFB401andWToilet, fourthFWToilet);
        NINEGRAPH.addConnectionsInTwoSides(fourthFK411one, fourthFK413one);

        NINEGRAPH.addConnectionsInTwoSides(fourthFK413one, fourthFK413two);
        NINEGRAPH.addConnectionsInTwoSides(fourthFK413one, fourthFK412one);
        NINEGRAPH.addConnectionsInTwoSides(fourthFK412one, fourthFK412two);
        NINEGRAPH.addConnectionsInTwoSides(fourthFK412one, fourthFB414and415);
        NINEGRAPH.addConnectionsInTwoSides(fourthFB414and415, fourthFK414);
        NINEGRAPH.addConnectionsInTwoSides(fourthFB414and415, fourthFK415);
        NINEGRAPH.addConnectionsInTwoSides(fourthFB414and415, fourthFK416);
        NINEGRAPH.addConnectionsInTwoSides(fourthFB414and415, fourthFB420and417A);
        NINEGRAPH.addConnectionsInTwoSides(fourthFB420and417A, fourthFK420);
        NINEGRAPH.addConnectionsInTwoSides(fourthFB420and417A, fourthFK417A);
        NINEGRAPH.addConnectionsInTwoSides(fourthFB420and417A, fourthFK419one);
        NINEGRAPH.addConnectionsInTwoSides(fourthFK419two, fourthFK419one);
        NINEGRAPH.addConnectionsInTwoSides(fourthFK419one, fourthFB424and422);
        NINEGRAPH.addConnectionsInTwoSides(fourthFB424and422, fourthFK422);
        NINEGRAPH.addConnectionsInTwoSides(fourthFB424and422, fourthFK424);
        NINEGRAPH.addConnectionsInTwoSides(fourthFB424and422, fourthFB421and426);
        NINEGRAPH.addConnectionsInTwoSides(fourthFB421and426, fourthFK421);
        NINEGRAPH.addConnectionsInTwoSides(fourthFB421and426, fourthFK426);
        NINEGRAPH.addConnectionsInTwoSides(fourthFB421and426, fourthFB430and423and428);
        NINEGRAPH.addConnectionsInTwoSides(fourthFB430and423and428, fourthFK423);
        NINEGRAPH.addConnectionsInTwoSides(fourthFB430and423and428, fourthFK428);
        NINEGRAPH.addConnectionsInTwoSides(fourthFB430and423and428, fourthFK430);
        NINEGRAPH.addConnectionsInTwoSides(fourthFB430and423and428, fourthFK427one);
        NINEGRAPH.addConnectionsInTwoSides(fourthFK427two, fourthFK427one);
        NINEGRAPH.addConnectionsInTwoSides(fourthFK425, fourthFK427two);
        NINEGRAPH.addConnectionsInTwoSides(fourthFB430and423and428, fourthFDRightStairs);


        NINEGRAPH.addConnectionsInTwoSides(fourthFDRightStairs, fourthFK429);
        NINEGRAPH.addConnectionsInTwoSides(fourthFDRightStairs, fourthFK431one);
        NINEGRAPH.addConnectionsInTwoSides(fourthFK431one, fourthFK431two);
        NINEGRAPH.addConnectionsInTwoSides(fourthFK431Aone, fourthFK431one);
        NINEGRAPH.addConnectionsInTwoSides(fourthFK431Aone, fourthFK431Atwo);
        NINEGRAPH.addConnectionsInTwoSides(fourthFDRightStairs, fourthFRightStairs);
        NINEGRAPH.addConnectionsInTwoSides(fourthFRightStairs, fourthFK433);
        NINEGRAPH.addConnectionsInTwoSides(fourthFRightStairs, fourthFB435and437);
        NINEGRAPH.addConnectionsInTwoSides(fourthFB435and437, fourthFK435);
        NINEGRAPH.addConnectionsInTwoSides(fourthFB435and437, fourthFK437);
        NINEGRAPH.addConnectionsInTwoSides(fourthFB435and437, fourthFB432and439);
        NINEGRAPH.addConnectionsInTwoSides(fourthFB432and439, fourthFK432);
        NINEGRAPH.addConnectionsInTwoSides(fourthFB432and439, fourthFK439);
        NINEGRAPH.addConnectionsInTwoSides(fourthFB432and439, fourthFB434and441andWC);
        NINEGRAPH.addConnectionsInTwoSides(fourthFB434and441andWC, fourthFK434);
        NINEGRAPH.addConnectionsInTwoSides(fourthFB434and441andWC, fourthFK441);
        NINEGRAPH.addConnectionsInTwoSides(fourthFB434and441andWC, fourthFWC);

        Vertex fifthFRightStairs = new Vertex("правая лестница", new Point(683, 369), 5);
        Vertex fifthFK533 = new Vertex("533", new Point(699, 369), 5);
        Vertex fifthFDRightStairs = new Vertex("ниже правой лестницы", new Point(676, 383), 5);
        Vertex fifthFK527 = new Vertex("527", new Point(676, 416), 5);
        Vertex fifthFK529 = new Vertex("529", new Point(706, 416), 5);
        Vertex fifthFK531one = new Vertex("подход 531", new Point(706, 383), 5);
        Vertex fifthFK531two = new Vertex("531", new Point(735, 416), 5);
        Vertex fifthFB535and518 = new Vertex("между 518 и 535", new Point(683, 337), 4);
        Vertex fifthFK518 = new Vertex("518", new Point(665, 337), 5);
        Vertex fifthFK535 = new Vertex("535", new Point(699, 337), 5);
        Vertex fifthFK537one = new Vertex("537 подход", new Point(683, 248), 5);
        Vertex fifthFK537two = new Vertex("537", new Point(699, 248), 5);
        Vertex fifthFB520and539 = new Vertex("между 520 и 539", new Point(683, 208), 5);
        Vertex fifthFK520 = new Vertex("520", new Point(665, 208), 5);
        Vertex fifthFK539 = new Vertex("539", new Point(699, 208), 5);
        Vertex fifthFWCone = new Vertex("WC подход", new Point(683, 256), 5);
        Vertex fifthFWCtwo = new Vertex("WC", new Point(665, 156), 5);

        Vertex fifthFK525one = new Vertex("подход 525", new Point(638, 383), 5);
        Vertex fifthFK525two = new Vertex("525", new Point(638, 416), 5);
        Vertex fifthFB523and516 = new Vertex("между 523 и 516", new Point(562, 383), 5);
        Vertex fifthFK516 = new Vertex("516", new Point(562, 369), 5);
        Vertex fifthFK523 = new Vertex("523", new Point(562, 416), 5);
        Vertex fifthFB514and519and517 = new Vertex("между 514,519 и 517", new Point(471, 383), 5);
        Vertex fifthFK519 = new Vertex("519", new Point(471, 416), 5);
        Vertex fifthFK517 = new Vertex("517", new Point(445, 416), 5);
        Vertex fifthFK514 = new Vertex("514", new Point(471, 369), 5);
        Vertex fifthFK521 = new Vertex("521", new Point(498, 435), 5);
        Vertex fifthFB512and515 = new Vertex("между 512 и 525", new Point(343, 383), 5);
        Vertex fifthFK512 = new Vertex("512", new Point(376, 369), 5);
        Vertex fifthFK515 = new Vertex("515", new Point(348, 416), 5);
        Vertex fifthFB513and510 = new Vertex("между 513 и 510", new Point(291, 383), 5);
        Vertex fifthFK513 = new Vertex("513", new Point(291, 416), 5);
        Vertex fifthFK510 = new Vertex("510", new Point(291, 369), 5);
        Vertex fifthFB511and506and508 = new Vertex("между 511,506 и 508", new Point(255, 383), 5);
        Vertex fifthFK511 = new Vertex("511", new Point(255, 416), 5);
        Vertex fifthFK506 = new Vertex("506", new Point(232, 369), 5);
        Vertex fifthFK508 = new Vertex("508", new Point(255, 369), 5);

        Vertex fifthFLeftStairs = new Vertex("левая лестница", new Point(114, 353), 5);
        Vertex fifthFK507 = new Vertex("507", new Point(95, 353), 5);
        Vertex fifthFK509one = new Vertex("подход 509", new Point(126, 383), 5);
        Vertex fifthFK509two = new Vertex("509", new Point(126, 416), 5);
        Vertex fifthFB505and504and503 = new Vertex("между 505,504 и 503", new Point(114, 270), 5);
        Vertex fifthFK505 = new Vertex("505", new Point(95, 281), 5);
        Vertex fifthFK504 = new Vertex("504", new Point(131, 270), 5);
        Vertex fifthFK503 = new Vertex("503", new Point(95, 249), 5);
        Vertex fifthFB501and502andMToilet = new Vertex("между 502,501 и MToilet", new Point(114, 167), 5);
        Vertex fifthFK502 = new Vertex("502", new Point(131, 145), 5);
        Vertex fifthFK501 = new Vertex("501", new Point(95, 145), 5);
        Vertex fifthFMToilet = new Vertex("MToilet", new Point(131, 172), 5);

        NINEGRAPH.addVertex(fifthFRightStairs);
        NINEGRAPH.addVertex(fifthFK533);
        NINEGRAPH.addVertex(fifthFDRightStairs);
        NINEGRAPH.addVertex(fifthFK527);
        NINEGRAPH.addVertex(fifthFK529);
        NINEGRAPH.addVertex(fifthFK531one);
        NINEGRAPH.addVertex(fifthFK531two);
        NINEGRAPH.addVertex(fifthFB535and518);
        NINEGRAPH.addVertex(fifthFK518);
        NINEGRAPH.addVertex(fifthFK535);
        NINEGRAPH.addVertex(fifthFK537one);
        NINEGRAPH.addVertex(fifthFK537two);
        NINEGRAPH.addVertex(fifthFB520and539);
        NINEGRAPH.addVertex(fifthFK520);
        NINEGRAPH.addVertex(fifthFK539);
        NINEGRAPH.addVertex(fifthFWCone);
        NINEGRAPH.addVertex(fifthFWCtwo);

        NINEGRAPH.addVertex(fifthFK525one);
        NINEGRAPH.addVertex(fifthFK525two);
        NINEGRAPH.addVertex(fifthFB523and516);
        NINEGRAPH.addVertex(fifthFK523);
        NINEGRAPH.addVertex(fifthFK516);
        NINEGRAPH.addVertex(fifthFB514and519and517);
        NINEGRAPH.addVertex(fifthFK514);
        NINEGRAPH.addVertex(fifthFK519);
        NINEGRAPH.addVertex(fifthFK517);
        NINEGRAPH.addVertex(fifthFK521);
        NINEGRAPH.addVertex(fifthFB512and515);
        NINEGRAPH.addVertex(fifthFK512);
        NINEGRAPH.addVertex(fifthFK515);
        NINEGRAPH.addVertex(fifthFB513and510);
        NINEGRAPH.addVertex(fifthFK513);
        NINEGRAPH.addVertex(fifthFK510);
        NINEGRAPH.addVertex(fifthFB511and506and508);
        NINEGRAPH.addVertex(fifthFK511);
        NINEGRAPH.addVertex(fifthFK506);
        NINEGRAPH.addVertex(fifthFK508);

        NINEGRAPH.addVertex(fifthFLeftStairs);
        NINEGRAPH.addVertex(fifthFK507);
        NINEGRAPH.addVertex(fifthFK509one);
        NINEGRAPH.addVertex(fifthFK509two);
        NINEGRAPH.addVertex(fifthFB505and504and503);
        NINEGRAPH.addVertex(fifthFK505);
        NINEGRAPH.addVertex(fifthFK504);
        NINEGRAPH.addVertex(fifthFK503);
        NINEGRAPH.addVertex(fifthFB501and502andMToilet);
        NINEGRAPH.addVertex(fifthFK501);
        NINEGRAPH.addVertex(fifthFK502);
        NINEGRAPH.addVertex(fifthFMToilet);

        NINEGRAPH.addConnectionsInTwoSides(fifthFLeftStairs, fifthFK509one);
        NINEGRAPH.addConnectionsInTwoSides(fifthFK509two, fifthFK509one);
        NINEGRAPH.addConnectionsInTwoSides(fifthFLeftStairs, fifthFK507);
        NINEGRAPH.addConnectionsInTwoSides(fifthFLeftStairs, fifthFB505and504and503);
        NINEGRAPH.addConnectionsInTwoSides(fifthFB505and504and503, fifthFK505);
        NINEGRAPH.addConnectionsInTwoSides(fifthFB505and504and503, fifthFK504);
        NINEGRAPH.addConnectionsInTwoSides(fifthFB505and504and503, fifthFK503);
        NINEGRAPH.addConnectionsInTwoSides(fifthFB505and504and503, fifthFB501and502andMToilet);
        NINEGRAPH.addConnectionsInTwoSides(fifthFB501and502andMToilet, fifthFK501);
        NINEGRAPH.addConnectionsInTwoSides(fifthFB501and502andMToilet, fifthFK502);
        NINEGRAPH.addConnectionsInTwoSides(fifthFB501and502andMToilet, fifthFMToilet);
        NINEGRAPH.addConnectionsInTwoSides(fifthFK509one, fifthFB511and506and508);


        NINEGRAPH.addConnectionsInTwoSides(fifthFB511and506and508, fifthFK508);
        NINEGRAPH.addConnectionsInTwoSides(fifthFB511and506and508, fifthFK506);
        NINEGRAPH.addConnectionsInTwoSides(fifthFB511and506and508, fifthFK511);
        NINEGRAPH.addConnectionsInTwoSides(fifthFB511and506and508, fifthFB513and510);
        NINEGRAPH.addConnectionsInTwoSides(fifthFB513and510, fifthFK510);
        NINEGRAPH.addConnectionsInTwoSides(fifthFB513and510, fifthFK513);
        NINEGRAPH.addConnectionsInTwoSides(fifthFB513and510, fifthFB512and515);
        NINEGRAPH.addConnectionsInTwoSides(fifthFB512and515, fifthFK512);
        NINEGRAPH.addConnectionsInTwoSides(fifthFB512and515, fifthFK515);
        NINEGRAPH.addConnectionsInTwoSides(fifthFB512and515, fifthFB514and519and517);
        NINEGRAPH.addConnectionsInTwoSides(fifthFB514and519and517, fifthFK514);
        NINEGRAPH.addConnectionsInTwoSides(fifthFB514and519and517, fifthFK517);
        NINEGRAPH.addConnectionsInTwoSides(fifthFB514and519and517, fifthFK519);
        NINEGRAPH.addConnectionsInTwoSides(fifthFB514and519and517, fifthFB523and516);
        NINEGRAPH.addConnectionsInTwoSides(fifthFK519, fifthFK521);
        NINEGRAPH.addConnectionsInTwoSides(fifthFB523and516, fifthFK523);
        NINEGRAPH.addConnectionsInTwoSides(fifthFB523and516, fifthFK516);
        NINEGRAPH.addConnectionsInTwoSides(fifthFB523and516, fifthFK525one);
        NINEGRAPH.addConnectionsInTwoSides(fifthFK525one, fifthFK525two);
        NINEGRAPH.addConnectionsInTwoSides(fifthFK525one, fifthFDRightStairs);


        NINEGRAPH.addConnectionsInTwoSides(fifthFDRightStairs, fifthFRightStairs);
        NINEGRAPH.addConnectionsInTwoSides(fifthFDRightStairs, fifthFK531one);
        NINEGRAPH.addConnectionsInTwoSides(fifthFK531one, fifthFK531two);
        NINEGRAPH.addConnectionsInTwoSides(fifthFK529, fifthFK531one);
        NINEGRAPH.addConnectionsInTwoSides(fifthFRightStairs, fifthFK533);
        NINEGRAPH.addConnectionsInTwoSides(fifthFB535and518, fifthFRightStairs);
        NINEGRAPH.addConnectionsInTwoSides(fifthFB535and518, fifthFK535);
        NINEGRAPH.addConnectionsInTwoSides(fifthFB535and518, fifthFK518);
        NINEGRAPH.addConnectionsInTwoSides(fifthFB535and518, fifthFK537one);
        NINEGRAPH.addConnectionsInTwoSides(fifthFK537one, fifthFK537two);
        NINEGRAPH.addConnectionsInTwoSides(fifthFK537one, fifthFB520and539);
        NINEGRAPH.addConnectionsInTwoSides(fifthFB520and539, fifthFK520);
        NINEGRAPH.addConnectionsInTwoSides(fifthFB520and539, fifthFK539);
        NINEGRAPH.addConnectionsInTwoSides(fifthFB520and539, fifthFWCone);
        NINEGRAPH.addConnectionsInTwoSides(fifthFWCone, fifthFWCtwo);


        NINEGRAPH.addConnectionsInTwoSides(fifthFRightStairs, fourthFRightStairs);
        NINEGRAPH.addConnectionsInTwoSides(fourthFRightStairs, thirdFRightStairs);
        NINEGRAPH.addConnectionsInTwoSides(thirdFRightStairs, secondFRightStairs);
        NINEGRAPH.addConnectionsInTwoSides(secondFRightStairs, firstFRightStairs);

        NINEGRAPH.addConnectionsInTwoSides(fifthFLeftStairs, fourthFLeftStairs);
        NINEGRAPH.addConnectionsInTwoSides(fourthFLeftStairs, thirdFLeftStairs);
        NINEGRAPH.addConnectionsInTwoSides(thirdFLeftStairs, secondFLeftStairs);
        NINEGRAPH.addConnectionsInTwoSides(secondFLeftStairs, firstFLeftStairs);

        NINEGRAPH.addConnectionsInTwoSides(fifthFRightStairs, fourthFRightStairs);
        NINEGRAPH.addConnectionsInTwoSides(fourthFRightStairs, thirdFRightStairs);
        NINEGRAPH.addConnectionsInTwoSides(thirdFRightStairs, secondFRightStairs);
        NINEGRAPH.addConnectionsInTwoSides(secondFRightStairs, firstFRightStairs);

        NINEGRAPH.addConnectionsInTwoSides(fifthFLeftStairs, fourthFLeftStairs);
        NINEGRAPH.addConnectionsInTwoSides(fourthFLeftStairs, thirdFLeftStairs);
        NINEGRAPH.addConnectionsInTwoSides(thirdFLeftStairs, secondFLeftStairs);
        NINEGRAPH.addConnectionsInTwoSides(secondFLeftStairs, firstFLeftStairs);
    }
}