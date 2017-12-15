import java.util.Scanner;
import java.lang.Math;

/**
 * The Node class represents a container which stores
 * no data. This particular node class does not deal
 * with 'children', rather only has a next method.
 * The typical getData, getNext, setData, setNext
 * are provided.
 * 
 * 
 * @author Gareth Sharpe
 * @since 01/12/2017
 */

public class RootBear {

	public static class Pair {

	    private int x;
	    private int y;

	    /**
		 * Creates a coordinate pair.
		 * 
		 * @param x, y coordinate pair. (int, int)
		 * @return None.
		 */
	    public Pair(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }

		/**
		 * Returns the y inside the pair.
		 * 
		 * @param Unused.
		 * @return y. (int)
		 */
	    public int getX() { return this.x; }

		/**
		 * Returns the x inside the pair.
		 * 
		 * @param Unused.
		 * @return x. (int)
		 */
	    public int getY() { return this.y; }
	}

	public static class Node {

		private Node next;
		private Pair pair;
		private int tree;

		/**
		 * Creates a node from supplied data and next node.
		 * 
		 * @param Data and the next node.
		 * @return None.
		 */
		public Node(Pair p, Node other, int tree) {
			this.pair = p;
			this.tree = tree;
			if (other == null)
				this.next = null;
			else
				this.next = new Node(other.pair, other.next, other.tree);
		}

		/**
		 * Returns the next node.
		 * 
		 * @param Unused.
		 * @return Next node. (Node)
		 */
	    public Node getNext() { return next; }

	    /**
		 * Sets the next node.
		 * 
		 * @param Node. (Node)
		 * @return None.
		 */
		public void setNext(Node node) {
			this.next = node;
			return;
		} 

		/**
		 * Returns the data inside a node.
		 * 
		 * @param Unused.
		 * @return Pair. (Pair)
		 */
		public Pair getCoords() { return this.pair; }

		/**
		 * Sets a node's coordinate pair.
		 * 
		 * @param Pair. (Pair)
		 * @return None.
		 */
		public void setCoords(Pair pair) { this.pair = pair; }

		/**
		 * Gets a node's current tree number.
		 * 
		 * @param None. 
		 * @return Tree. (int)
		 */
		public int getTree() { return this.tree; }

		/**
		 * Prints string representation of the data contained in a node.
		 * 
		 * @param Unused.
		 * @return String representation of data. (String)
		 */
		public String toString() {
			return "x: " + this.pair.x + "; y: " + this.pair.y;
		}

		/**
		 * Returns the distance from one Node to a pole.
		 * 
		 * @param Pole. (Node)
		 * @return Distance to Pole. (Double)
		 */
		public double distanceToPole(Node pole) {
			int y1 = this.getCoords().getY();
			int y2 = pole.getCoords().getY();
			double abs = Math.pow(y1 - y2, 2);
			return Math.sqrt(abs);
		}

		/**
		 * Returns the distance from one Node to another Node.
		 * 
		 * @param Neighbour. (Node)
		 * @return Distance to neighbour. (Double)
		 */
		public double distanceToNeighbour(Node neighbour) {
			int x1 = this.getCoords().getX();
			int x2 = neighbour.getCoords().getX();
			int y1 = this.getCoords().getY();
			int y2 = neighbour.getCoords().getY();
			double absx = Math.pow(x2 - x1, 2);
			double absy = Math.pow(y2 - y1, 2);
			return Math.sqrt(absx + absy);
		}
	}

	public static class Table {

		private Node[] ancestors;
		private int[] discoveries;
		private int[] finishes;
		private int[] colours;

		/**
		 * Creates a table from supplied table size.
		 * 
		 * @param Data size. (Int)
		 * @return None.
		 */
		public Table(int size) {
			this.ancestors = new Node[size];
			this.discoveries = new int[size];
			this.finishes= new int[size];
			this.colours = new int[size];
		}

		/**
		 * Gets a node's ancestor.
		 * 
		 * @param Descendent. (Node) 
		 * @return Ancestor. (Node)
		 */
		public Node getAncestor(Node descendent) {
			int tree = descendent.getTree();
			return this.ancestors[tree];
		}

		/**
		 * Gets a node's discovery time.
		 * 
		 * @param Node. (Node) 
		 * @return Discovery time. (Int)
		 */
		public int getDiscovery(Node node) { 
			int tree = node.getTree();
			return this.discoveries[tree]; 
		}

		/**
		 * Gets a node's finish time.
		 * 
		 * @param Node. (Node) 
		 * @return Finish time. (Int)
		 */
		public int getFinish(Node node) { 
			int tree = node.getTree();
			return this.finishes[tree]; 
		}

		/**
		 * Gets a node's colour.
		 * 
		 * @param Node. (Node) 
		 * @return Colour. (Int)
		 */
		public int getColour(Node node) {
			int tree = node.getTree();
			return this.colours[tree];
		}

		/**
		 * Sets a node's ancestor.
		 * 
		 * @param Ancestor, Descendent. (Node, Node) 
		 * @return None.
		 */
		public void setAncestor(Node ancestor, Node descendent) {
			int tree = descendent.getTree();
			this.ancestors[tree] = ancestor;
		}

		/**
		 * Sets a node's discovery time.
		 * 
		 * @param Node, discovoery time. (Node, Int) 
		 * @return None.
		 */
		public void setDiscovery(Node node, int time) {
			int tree = node.getTree();
			this.discoveries[tree] = time;
		}

		/**
		 * Sets a node's finish time.
		 * 
		 * @param Node, finish time. (Node, Int) 
		 * @return None.
		 */
		public void setFinish(Node node, int time) {
			int tree = node.getTree();
			this.finishes[tree] = time;
		}

		/**
		 * Sets a node's colour.
		 * 
		 * @param Node, colour. (Node, Int) 
		 * @return None.
		 */
		public void setColour(Node node, int colour) {
			int tree = node.getTree();
			this.colours[tree] = colour;
		}

	}

	public static class Stack {

		private Node[] stack;
		private int i = 0;
		private int n;

		/**
		 * Creates a stack from supplied stack size.
		 * 
		 * @param Data size. (Int)
		 * @return None.
		 */
		public Stack(int size) {
			this.stack = new Node[size];
			this.n = size;
		}

		/**
		 * Pushes a node onto the stack.
		 * 
		 * @param Node. (Node)
		 * @return None.
		 */
		public void push(Node node) {
			this.stack[i] = node;
			i++;
		}

		/**
		 * Pops a node off the stack.
		 * 
		 * @param None.
		 * @return Node. (Node)
		 */
		public Node pop() {
			i--;
			return this.stack[i];
		}

		/**
		 * Determines if stack is empty.
		 * 
		 * @param None.
		 * @return Empty. (Boolean)
		 */
		public boolean isEmpty() {
			return this.i == 0;
		}

		/**
		 * Determines if stack is full.
		 * 
		 * @param None.
		 * @return Full. (Boolean)
		 */
		public boolean isFull() {
			return this.i == this.n;
		}

	}

	/**
	 * Prints the contents of a graph represented
	 * as an adjacency list.
	 * 
	 * @param Adjacency list of Nodes. (Node[])
	 * @return None.
	 */
	public static void printGraph(Node[] graph) {
		int n = graph.length;
		for (int i = 0; i < n; i++) {
			if (graph[i] != null) {
				Node current = graph[i];
				while (current != null) {
					System.out.printf("| %s | -> ", current.toString());
					current = current.getNext();
				}
				System.out.printf("null\n");
			}
		}
	}

	/**
	 * Appends a node at a given position in a graph.
	 * 
	 * @param Adjacency list of Nodes, Node, index. (Node[], Node, Int)
	 * @return None.
	 */
	public static void append(Node[] graph, Node node, int i) {
		Node current = graph[i];
		if (current == null)
			graph[i] = node;
		else {
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(node);
		}
	}

	/**
	 * Visits a Node in a graph. Helper function for DFS.
	 * 
	 * @param Table, stack, graph, node, current time. (Table, Stack, Node[], Node, Int)
	 * @return None.
	 */
	public static void DFSVisit(Table table, Stack stack, Node[] graph, Node node, int time) {
		time++;
		table.setDiscovery(node, time);
		table.setColour(node, GREY);
		Node next = graph[node.getTree()];
		stack.push(node);
		while (next != null) {
			if (table.getColour(next) == WHITE) 
				DFSVisit(table, stack, graph, next, time);
			next = next.getNext();
		}
		table.setColour(node, BLACK);
		time++;
		table.setFinish(node, time);
		node = stack.pop();
	}

	/**
	 * Performs a depth-first search on a graph.
	 * 
	 * @param Graph. (Node[])
	 * @return Full table. (Table)
	 */
	public static Table DFS(Node[] graph) {
		int n = graph.length; 
		int time = 0;

		Table table = new Table(n);
		Stack stack = new Stack(n);

		Node current = graph[0];

		DFSVisit(table, stack, graph, current, time);

		return table;
	}

	// Constants
	private static final int NORTH = 0;
	private static final int SOUTH = 1;
	private static final int POLES = 2;
	private static final int WHITE = 0;
	private static final int GREY = 1;
	private static final int BLACK = 2;

	// Boolean variables
	private static boolean bearShouldTry = true;
	private static boolean bearMadeIt = false;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int south = scanner.nextInt();
		int north = scanner.nextInt();
		int bear = scanner.nextInt();
		int trees = scanner.nextInt();

		Node[] graph = new Node[trees + POLES];

		Pair northPair = new Pair(0, north);
		Pair southPair = new Pair(0, south);
		Node northNode = new Node(northPair, null, NORTH);
		Node southNode = new Node(southPair, null, SOUTH);

		graph[NORTH] = northNode;
		graph[SOUTH] = southNode;

		int tree = POLES; int x; int y;
		while (tree < trees + POLES) {
			x = scanner.nextInt();
			y = scanner.nextInt();
			Pair pair = new Pair(x, y);
			Node node = new Node(pair, null, tree);

			if (graph[tree] == null)
				append(graph, node, tree);

			double toNorth = node.distanceToPole(northNode);
			double toSouth = node.distanceToPole(southNode);

			if (toNorth < bear && toSouth < bear)
				bearShouldTry = false;

			if (toNorth < bear) {
				node = new Node(pair, null, tree);
				northNode = new Node(northPair, null, NORTH);
				append(graph, node, NORTH);
				append(graph, northNode, tree);
			}

			if (toSouth < bear) {
				node = new Node(pair, null, tree);
				southNode = new Node(southPair, null, SOUTH);
				append(graph, node, SOUTH);
				append(graph, southNode, tree);
			}

			for (int i = POLES; i < tree; i++) {
				Node neighbour = graph[i];
				double toNeighbour = node.distanceToNeighbour(neighbour);
				if (toNeighbour < bear) {
					node = new Node(pair, null, tree);
					append(graph, node, i);
					neighbour = new Node(neighbour.getCoords(), null, neighbour.getTree());
					append(graph, neighbour, tree);
				}
			}
			tree++;
		}

		if (bearShouldTry) {
			Table table = DFS(graph);
			int northDiscovery = table.getDiscovery(northNode);
			int southDiscovery = table.getDiscovery(southNode);
			int northFinish = table.getFinish(northNode);
			int southFinish = table.getFinish(southNode);
			if (table.getColour(southNode) != WHITE) {
				if (northDiscovery < southDiscovery &&
					northFinish > southFinish)
					bearMadeIt = true;
			} else {
				bearMadeIt = true;
			}
		}

		if (bearMadeIt)
			System.out.println("YES");
		else
			System.out.println("NO");

		scanner.close();
	}
}
