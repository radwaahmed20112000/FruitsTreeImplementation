#include <iostream>
#include <typeinfo>
#include <vector>
using namespace std;
class Fruit {
private:
    int weight ;
    string name ;
public:



    const string &getName() const {
        return name;
    }

    void setName(const string &name) {
        Fruit::name = name;
    }

public:
    //weight and left and right child

    Fruit *left = NULL ;
    Fruit *right = NULL;

    int getWeight() const {
        return weight;
    }

    void setWeight(int weight) {
        Fruit::weight = weight;
    }
};
//virtual solves the diamond problem
class Oval : virtual public Fruit{

};
class Large :virtual public Fruit{

};
class Tiny :virtual public Fruit{

};
class Berry :virtual public Fruit{
public:


};
class NotOval :virtual public Fruit{

};
class Apple : public Oval,public Large{
public:

    Apple(int w,string s)
    {
        setWeight(w);
        setName(s) ;
    }

};
class Blackberries : public Tiny,public Berry{
public:

    Blackberries(int w,string s){
        setWeight(w) ;
        setName(s) ;
    }
};
class Elderberries : public Berry,public Tiny{
public:

    Elderberries(int w,string s){
        setWeight(w) ;
        setName(s);
    }
};
class Gooseberries  : public Berry,public Tiny{
public:

    Gooseberries(int w,string s){
        setWeight(w) ;
        setName(s) ;
    }
};
class Blueberries  : public Berry,public Tiny{
public:

    Blueberries(int w,string s){
        setWeight(w) ;
        setName(s) ;
    }
};
class grapes   : public Berry,public Tiny{
 public:

     grapes(int w,string s){
         setWeight(w) ;
         setName(s) ;
     }
};
class Cherries   : public Berry,public  Tiny{
public:

    Cherries(int w,string s){
        setWeight(w) ;
        setName(s);
    }
};
class Watermelon   : public Large,public Oval{
public:

    Watermelon(int w,string s){
        setWeight(w) ;
        setName(s) ;
    }
};

class Pineapple   : public Large,public Oval{
public:

    Pineapple(int w,string s){
        setWeight(w) ;
        setName(s) ;
    }
};
class Melon   : public Large,public Oval{
public:

    Melon(int w,string s){
        setWeight(w) ;
        setName(s) ;
    }
};
class Orange : public Oval,public Large{
public:

    Orange(int w,string s){
        setName(s) ;
        setWeight(w) ;
    }
};
class Mandrin : public Oval,public Large{
public:

    Mandrin(int w,string s){
        setName(s) ;
        setWeight(w) ;
    }
};
class Mango : public Oval,public Large{
public:

    Mango(int w,string s){
        setName(s);
        setWeight(w) ;
    }
};
class Avocado : public Oval,public Large{
public:

    Avocado(int w,string s){
        setName(s) ;
        setWeight(w) ;
    }
};
class Peache : public Oval,public Tiny{
public:

    Peache(int w,string s){
        setName(s) ;
        setWeight(w) ;
    }
};
class Plum : public Oval,public Tiny{
public:

    Plum(int w,string s){
        setName(s) ;
        setWeight(w) ;
    }
};

class Pomegranate : public Oval,public Large{
public:

    Pomegranate(int w,string s){
        setName(s) ;
        setWeight(w) ;
    }
};
class Banana : public NotOval,public Large{
public:

    Banana(int w,string s){
        setName(s) ;
        setWeight(w) ;
    }
};
class Strawberry : public Oval,public Tiny{
public:

    Strawberry(int w,string s){
        setName(s) ;
        setWeight(w) ;
    }
};
//Abstract methods to be implemented in extended class
class AbstractMethods {
    //Abstract methods
public:

    virtual void Iterate() = 0 ;
    virtual void filterByType(Fruit fruit) = 0 ;
    virtual void filterByWeight(int weight) = 0 ;
    virtual void magnifyByType(Fruit fruit,int weight) = 0 ;
    virtual Fruit* findHeaviest() = 0 ;
    virtual Fruit* findLightest() = 0 ;

};
class HelperMethods {
public:

    //helper function
    void inordertravesal(Fruit* fruit){
        if (fruit == NULL){
            return;
        }
        inordertravesal(fruit->left);
        cout<<fruit->getName()<< " " << fruit->getWeight()<< '\n'   ;
        inordertravesal(fruit->right);
    }
    //helper function for filterbytype
    void inordertype(Fruit* fruit,Fruit f){
        if (fruit == NULL){
            return;
        }
        inordertype(fruit->left,f);
        //if same fruit
        if(f.getName().compare(fruit->getName()) == 0){
            cout<<fruit->getName()<< " " << fruit->getWeight() << '\n'  ;
        }

        inordertype(fruit->right,f);
    }
    //helper function for filterbyWeight
    void inorderweight(Fruit* fruit,int w){
        if (fruit == NULL){
            return;
        }
        inorderweight(fruit->left,w);
        //if same fruit
        if(w == fruit->getWeight()){
            cout<<fruit->getName()<< " " << fruit->getWeight() << '\n'  ;
        }
        inorderweight(fruit->right,w);
    }
    //helper function for magnifyByType
    void inordermagnify(Fruit* fruit,Fruit f , int w){
        if (fruit == NULL){
            return;
        }
        inordermagnify(fruit->left,f,w);
        if(fruit->getName().compare(f.getName()) == 0){
            fruit->setWeight(fruit->getWeight() + w) ;
        }

        inordermagnify(fruit->right,f,w);
    }
    //Helper function for findheaviest
    Fruit* getmax(Fruit* fruit){
        Fruit* f = fruit ;
        while (f->right!=NULL){
            f = f->right ;
        }
        return f  ;


    }
    //Helper function for findLightest
    Fruit* getmin(Fruit* fruit) {
        Fruit* f = fruit ;
        while (f->left != NULL) {
            f = f->left;
        }
        return f;

    }
        //
};
//apply overriding
class MethodImplementation : public AbstractMethods{
//Delgation by methods
HelperMethods helperMethods ;
public:
    //Apply delegation by delegation a fruit object
    Fruit* fruit_root = NULL ;

 void insert( Fruit fruit) {

        Fruit* node = fruit_root;
        //if the tree is empty
        if (node == NULL) {

            fruit_root = &fruit;
            return;
        }
        while (node->getWeight() != fruit.getWeight()) {
            if (node->getWeight() < fruit.getWeight()) {
                if (! (node->right==NULL) ) {
                    node = node->right;
                } else
                    break;
            } else {
                if (! (node->left==NULL) ) {
                    //System.out.println("node's key = " + key + " node's leftChild key = " + node.getLeftChild().getKey());
                    node = node->left;
                } else
                    break;
            }
        }
        //if the key is present in the tree
        if (node->getWeight() == fruit.getWeight()) {
            node->setName(fruit.getName());
            return;
        }
        if (node->getWeight() < fruit.getWeight())
            node->right = &fruit ;
        else
            node->left= &fruit;

    }
    //Override Methods to be implemented

    //iterate function
    void Iterate() {
        helperMethods.inordertravesal(fruit_root) ;
    }

    //filterByType Method
    void filterByType(Fruit fruit){
        helperMethods.inordertype(fruit_root,fruit) ;
    }

    //filterByWeight Method
    void filterByWeight(int Weight){
        helperMethods.inorderweight(fruit_root,Weight) ;
    }

    //MagnifyByType function
    void magnifyByType(Fruit fruit,int Weight){


        helperMethods.inordermagnify(fruit_root,fruit,Weight) ;


    }

    //findHeaviest Function
    Fruit* findHeaviest(){
        return  helperMethods.getmax(fruit_root) ;
    }


    //findHeaviest Function
    Fruit* findLightest(){
        return  helperMethods.getmin(fruit_root) ;
    }

};



int main() {
    Apple apple1 = *new Apple(10,"apple") ;
    Apple apple2 = *new Apple(11,"apple") ;
    Apple apple3 = *new Apple(12,"apple") ;
    Blackberries blackberries = *new  Blackberries(5,"blackberries");
    Mango mango = *new Mango(70,"mango") ;
    Strawberry strawberry = *new Strawberry(4,"strawberry") ;

    MethodImplementation tree  ;


    tree.insert(apple1) ;
    tree.insert(apple2) ;
    tree.insert(apple3) ;
    tree.insert(mango) ;
    tree.insert(blackberries) ;
    tree.insert(strawberry) ;

    //tree.Iterate();
   // tree.filterByType(apple1) ;
    //tree.filterByWeight(11) ;
    //
    //tree.magnifyByType(apple1,50) ;
    //tree.Iterate();
    //
    //Fruit* f = tree.findHeaviest() ;
   //cout<<f->getName() << " " <<f->getWeight() ;
   //
   Fruit* f1 = tree.findLightest(); ;
    cout<<f1->getName() << " " <<f1->getWeight() ;






    return 0;
}






