"use strict";

angularPersonApp.controller('homeController', function($scope) {
    $scope.user = 'Gandalf';
});


angularPersonApp.controller('personsController', function($scope, $http) {
    $scope.persons = [];

    $scope.getAllPersons = function() {
        $http.get('http://localhost:9090/persons')
                .then(function (response) {
                    $scope.persons = response.data;
                })
                .catch(function (response) {
                    document.getElementById('errors').innerHTML = "Erreur lors de l'appel du json"
                })
        ;
    };

    $scope.$watch('persons', function () {
        let length = $scope.persons.length;
        $scope.label = '';

        if (length === 0) {
            $scope.label = 'Pas de personne';
        } else if(length === 1) {
            $scope.label = '1 personne';
        } else {
            $scope.label = length + ' personnes';
        }
    }, true);


    $scope.openFormToAdd = function() {
        $scope.person = {};
        $scope.modalTitle = 'Ajouter une personne';
        $('#person-form-modal').modal('show');
    };

    $scope.openFormToEdit = function(personToEdit) {
        $scope.person = angular.copy(personToEdit);
        $scope.modalTitle = 'Modifier une personne';
        $('#person-form-modal').modal('show');
    };

    $scope.addPerson = function(person) {
        $http.post('http://localhost:9090/persons', person)
                .then(function (response) {
                    document.getElementById('infos').innerHTML = 'Personne correctement ajoutée !';

                    $scope.person = {};
                    $scope.personForm.$setPristine();
                    $('#person-form-modal').modal('hide');

                    $scope.getAllPersons();
                })
                .catch(function (response) {
                    document.getElementById('errors').innerHTML = "Erreur lors de l'envoi";
                })
        ;
    };

    $scope.editPerson = function(person) {
        $http.patch('http://localhost:9090/persons/' + person.id, person)
                .then(function (response) {
                    document.getElementById('infos').innerHTML = 'Personne correctement modifiée !';

                    $scope.person = {};
                    $scope.personForm.$setPristine();
                    $('#person-form-modal').modal('hide');

                    $scope.getAllPersons();
                })
                .catch(function (response) {
                    document.getElementById('errors').innerHTML = "Erreur lors de l'envoi";
                })
        ;
    };

    $scope.removePerson = function (person) {
        $http.delete('http://localhost:9090/persons/' + person.id)
                .then(function () {
                    // on recupere l'index de l'element à supprimer dans le tableau
                    let index = $scope.persons.indexOf(person);
                    // on supprime l'element du tableau de personnes
                    $scope.persons.splice(index, 1);
                })
                .catch(function (response) {
                    document.getElementById('errors').innerHTML = 'Erreur lors de la suppression';
                })
        ;
    }
});
