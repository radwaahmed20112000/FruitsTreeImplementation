
// 1st Level of Hierachy of Structure of Fruits

function Fruit() {}
Fruit.prototype = {

    weight: undefined,
    superType: undefined,
    type: undefined,

    setWeight: function(x) { this.weight = x; },
    incWeight: function(x) { this.weight = this.getWeight() + x; },
    getWeight: function() { return this.weight; },
    getSuperType: function() { return this.superType; },
    getType: function() { return this.type; },

    // Node Extentions

    left: null, 
    right: null,
    setLeft: function(x) { this.left = x;},
    setRight: function(x) { this.right = x;},
    getLeft: function() { return this.left; },
    getRight: function() { return this.right; }
}


// 2nd Level of Hierachy of Super Types of Fruits

function Tiny() {}
Tiny.prototype = {
    __proto__: Fruit.prototype,
    superType: "tiny",
    getSuperType: function() { return "tiny"; }
}

function Large() {}
Large.prototype = {
    __proto__: Fruit.prototype,
    superType: "large",
    getSuperType: function() { return "large"; }
}

function Oval() {}
Oval.prototype = {
    __proto__: Fruit.prototype,
    superType: "oval",
    getSuperType: function() { return "oval"; }
}

function NotOval() {}
NotOval.prototype = {
    __proto__: Fruit.prototype,
    superType: "notoval",
    getSuperType: function() { return "notoval"; }
}

function Berry() {}
Berry.prototype = {
    __proto__: Fruit.prototype,
    superType: "berry",
    getSuperType: function() { return "berry"; }
}


// 3rd Level of Hierachy of Types of Fruits

function cherries() {}
cherries.prototype = {
    __proto__: Tiny.prototype,
    type: "cherries",
}

function grapes() {}
grapes.prototype = {
    __proto__: Tiny.prototype,
    type: "grapes",
}

function melon() {}
melon.prototype = {
    __proto__: Large.prototype,
    type: "melon"
}

function pineapple() {}
pineapple.prototype = {
    __proto__: Large.prototype,
    type: "pineapple"
}

function orange() {}
orange.prototype = {
    __proto__: Oval.prototype,
    type: "orange"
}

function mandrin() {}
mandrin.prototype = {
    __proto__: Oval.prototype,
    type: "mandrin" 
}

function watermelon() {}
watermelon.prototype = {
    __proto__: Large.prototype,
    type: "watermelon"
}

function mango() {}
mango.prototype = {
    __proto__: Oval.prototype,
    type: "mango"
}

function avocado() {}
avocado.prototype = {
    __proto__: Oval.prototype,
    type: "avocado"
}

function apple() {}
apple.prototype = {
    __proto__: Oval.prototype,
    type: "apple"
}

function plum() {}
plum.prototype = {
    __proto__: Oval.prototype,
    type: "plum"
}

function peache() {}
peache.prototype = {
    __proto__: Oval.prototype,
    type: "peache"
}

function pomegranate() {}
pomegranate.prototype = {
    __proto__: Oval.prototype,
    type: "pomegranate"
}

function cantaloupe() {}
cantaloupe.prototype = {
    __proto__: Oval.prototype,
    type: "cantaloupe"
}

function bananas() {}
bananas.prototype = {
    __proto__: NotOval.prototype,
    type: "bananas"
}

function strawberry() {}
strawberry.prototype = {
    __proto__: NotOval.prototype,
    type: "strawberry"
}

function blackberries() {}
blackberries.prototype = {
    __proto__: Berry.prototype,
    type: "blackberries"
}

function elderberries() {}
elderberries.prototype = {
    __proto__: Berry.prototype,
    type: "elderberries"
}

function gooseberries() {}
gooseberries.prototype = {
    __proto__: Berry.prototype,
    type: "gooseberries"
}

function blueberries() {}
blueberries.prototype = {
    __proto__: Berry.prototype,
    type: "blueberries"
}

function BinarySearchTree () { 
   this._root = null;
}
BinarySearchTree.prototype = {

    constructor: BinarySearchTree,   

    insert : function (node) {
       
        var current = undefined; // used to traverse the structure
        // special case: no items in the tree yet
        if (this._root == null) {
            this._root = node;
        }else {
            current = this._root;
            while (true) {
  
                // if the new value is less than this node's value, go left
                if (node.getWeight() <current.getWeight()) {
                    // if there's no left, then the new node belongs there
                    if (current.getLeft() === null) {
                        current.setLeft(node);
                        break;
                    } 
                    else {
                        current = current.getLeft();
                    }
  
                // if the new value is greater than this node's value, go right
                } else if (node.getWeight()> current.getWeight()) { 
                    // if there's no right, then the new node belongs there
                    if (current.getRight() === null) {
                        current.setRight(node);
                        break;
                    } else {
                        current = current.getRight();
                    }       
                // if the new value is equal to the current one, just ignore
                } else {
                    console.log("/!\\ Alert : You Can't enter 2 fruits of the same weight ")
                    break;
                }
            }
        }
    },

    // a method that prints the in-order traversal of the tree.

    iterate: function () {
        var result = [];
        var current = this._root;
        var traverse = function(node) {
            node.getLeft() && traverse(node.getLeft());
            result.push(node);
            node.getRight() && traverse(node.getRight());
        };
        // Inorder Traversal of the tree
        traverse(current);
        // Print the tree in inorder traversal form 
        for(var i = 0; i < result.length; i++){
            console.log("Fruit Super Type: " + result[i].getSuperType() + ", Fruit Type: " + result[i].getType() + ", Weight: " + result[i].getWeight());
        }
    },

    // a method that prints the nodes of a given fruit type ordered by weight.

    filterByType: function (type) {
        var result = [];
        var current = this._root;
        var traverse = function(node) {
            node.getLeft() && traverse(node.getLeft());
            result.push(node);
            node.getRight() && traverse(node.getRight());
        };
        // Inorder Traversal of the tree
        traverse(current);
        var j = 0;
        for(var i = 0; i < result.length; i++){
            // check if the entered type is existed in the tree to print them 
            if(result[i].getType() == type || result[i].getSuperType() == type ) {
                console.log("Fruit Super Type: " + result[i].getSuperType() + ", Fruit Type: " + result[i].getType() + ", Weight: " + result[i].getWeight());            }
            else {
                j++;
                if (j == result.length) {
                    console.log("/!\\ Alert : There is no such type of FRUITS :'( ");
                }
            }
        }
    },

    // a method that prints the nodes that have weight larger than the given amount ordered by weight.

    filterByWeight: function (weight) {
        var result = [];
        var current = this._root;
        var traverse = function(node) {
            node.getLeft() && traverse(node.getLeft());
            result.push(node);
            node.getRight() && traverse(node.getRight());
        };
        // Inorder Traversal of the tree
        traverse(current);
        var j = 0;
        for(var i = 0; i < result.length; i++){
            // check if there exists a larger weight than the entered one to print them 
            if(result[i].getWeight() > weight) {
                console.log("Fruit Super Type: " + result[i].getSuperType() + ", Fruit Type: " + result[i].getType() + ", Weight: " + result[i].getWeight());            }
            else {
                j++;
                if (j == result.length) {
                    console.log("/!\\ Alert : There is no such weight of FRUITS :'( ");
                }
            }
        }
    },

    // a method that increases the weight of the nodes of a given fruit type by the given amount.

    magnifyByType: function (type, weight) {
        var result = [];
        var current = this._root;
        var traverse = function(node) {
            node.getLeft() && traverse(node.getLeft());
            result.push(node);
            node.getRight() && traverse(node.getRight());
        };
        // Inorder Traversal of the tree 
        traverse(current);
        var j=0; 
        for(var i = 0; i < result.length; i++){
            // check if the entered type is existed in the tree to increase it
            if(result[i].getType() == type || result[i].getSuperType() == type) {
                result[i].incWeight(weight);
            }
            else {
                j++;
                if (j == result.length) {
                    console.log("/!\\ Alert : There is no such type of FRUITS :'( ");
                    return;
                }
            }
        }
        // editing the tree to retrieve its binary search tree form
        this._root = undefined;
        for(var i = 0; i < result.length; i++) {
            result[i].setLeft(null);
            result[i].setRight(null);
            this.insert(result[i]);
        }
    },

    // a method that finds the node with the greatest weight in the tree.

    findHeaviest: function() {
        var current = this._root;
        var traverseHeavist = function(node) {
          return !node.getRight() ? node : traverseHeavist(node.getRight());
        };
        if (current == null || current == undefined) {
            return null;
        }
        else {
            return traverseHeavist(current);
        }
    },

    // a method that finds the node with the least weight in the tree.

    findLightest: function() {
        var current = this._root;
        var traverseLightest = function(node) {
          return !node.getLeft() ? node : traverseLightest(node.getRight());
        };
        if (current == null || current == undefined) {
            return null;
        }
        else {
            return traverseLightest(current);
        }
    }

}

/*-----------------------------------------------------------Main Tester-------------------------------------------------------------------*/

// (1) Creating objects nodes from specific fruits prototypes

var blueberry1 = Object.create(blueberries.prototype);
var blueberry2 = Object.create(blueberries.prototype);
var bananas1 = Object.create(bananas.prototype);
var bananas2 = Object.create(bananas.prototype);
var apple1 = Object.create(apple.prototype);
var apple2 = Object.create(apple.prototype);
var watermelon1 = Object.create(watermelon.prototype);
var watermelon2 = Object.create(watermelon.prototype);
var grapes1 = Object.create(grapes.prototype);
var grapes2 = Object.create(grapes.prototype);

// (2) Setting the weights of them

blueberry1.setWeight(20);
blueberry2.setWeight(30);
bananas1.setWeight(100);
bananas2.setWeight(120);
apple1.setWeight(70);
apple2.setWeight(90);
watermelon1.setWeight(500);
watermelon2.setWeight(700);
grapes1.setWeight(140);
grapes2.setWeight(150);

// (3) Building the binary search tree

var bst = Object.create(BinarySearchTree.prototype);

bst.insert(blueberry1);
bst.insert(blueberry2);
bst.insert(bananas1);
bst.insert(bananas2);
bst.insert(apple1);
bst.insert(apple2);
bst.insert(watermelon1);
bst.insert(watermelon2);
bst.insert(grapes1);
bst.insert(grapes2);

// (4) Testing iterate Method

console.log("------------------(1) Testing iterate Method---------------------\n");
bst.iterate();

// (5) Testing filterByWeight Method

console.log("\n----------------(2) Testing filterByWeight Method-----------------\n");
bst.filterByWeight(90);

// (6) Testing filterByType Method

console.log("\n----------------(3) Testing filterByType Method------------------\n");
bst.filterByType("grapes");

// (7) Testing magnifyByType Method

console.log("\n----------------(4) Testing magnifyByType Method------------------\n");
bst.magnifyByType("bananas", 500);
bst.iterate();

// (8) Testing findHeaviest Method

console.log("\n----------------(5) Testing findHeaviest Method------------------\n");
console.log("Fruit Super Type: " + bst.findHeaviest().getSuperType() + ", Fruit Type: " + bst.findHeaviest().getType() + ", Weight: " + bst.findHeaviest().getWeight());

// (9) Testing findLightest Method

console.log("\n-----------------(6) Testing findLightest Method-------------------\n");
console.log("Fruit Super Type: " + bst.findLightest().getSuperType() + ", Fruit Type: " + bst.findLightest().getType() + ", Weight: " + bst.findLightest().getWeight());





