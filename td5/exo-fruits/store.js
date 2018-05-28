var store = angular.module("store", []);

store.controller("MonController",
    function ($scope) {
        $scope.nouveau = false;
        $scope.panier = [];
        $scope.fruits = fruitsData;

        $scope.addToCart = function (fruit) {
            /*add the fruit to the cart*/
            if (fruit.name in $scope.panier) {
                $scope.panier[fruit.name]['quantity']++;
            } else {
                $scope.panier.push(fruit.name);
                $scope.panier[fruit.name] = {'price': fruit.price, 'quantity': 1};
            }
        };

        $scope.getNumberInCart = function () {
            let num = 0;

            $scope.panier.forEach(function (element) {
                num += $scope.panier[element]['quantity'];
            });

            return num;
        };

        $scope.getAmountOfCart = function () {
            let amount = 0;

            $scope.panier.forEach(function (element) {
                amount += $scope.panier[element]['quantity'] * $scope.panier[element]['price'];
            });

            return amount;
        };
    });


// DATA
const fruitsData = [
    {
        "name": "Banane",
        "price": 10,
        "desc": "Super fruits jaune",
        "canPurchase": true,
        "outOfStock": false,
        "image": {
            full: 'img\\banane.full.jpg',
            thumb: 'img\\banane.thumb.jpg'
        }
    },
    {
        "name": "Pomme",
        "price": 7,
        "desc": "Super fruits pour de la compote",
        "canPurchase": true,
        "outOfStock": true,
        "image": {
            full: 'img\\banane.full.jpg',
            thumb: 'img\\banane.thumb.jpg'
        }
    },
    {
        "name": "Prune",
        "price": 7,
        "desc": "Fruit qui a le nom d'une couleur",
        "canPurchase": false,
        "outOfStock": false,
        "image": {
            full: 'img\\prune.full.jpg',
            thumb: 'img\\prune.thumb.jpg'
        }
    },
    {
        "name": "Fraise",
        "price": 3,
        "desc": "De la famille des fruits rouges, sympas en glace",
        "canPurchase": true,
        "outOfStock": false,
        "image": {
            full: 'img\\fraise.full.jpg',
            thumb: 'img\\fraise.thumb.jpg'
        }
    }
];
