(function() {
  var ctrls = angular.module('controllers');
  ctrls.controller('BiaoBingCtrl', [
    '$scope',
    '$log',
    'DataService',
    BiaoBingCtrl
  ]);

  function BiaoBingCtrl($scope, $log, DataService) {
    $log.debug('BiaoBingCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('BiaoBingCtrl destroy...');
    });

    $scope.voteInfo = { nums: 35, voteCount: 1923, vistors: 23412 };

    DataService.send('/data/biaobingInfos', {}, function(data) {
      $scope.items = data.datas.list;
    });

    $scope.items = [];
  }
})();
