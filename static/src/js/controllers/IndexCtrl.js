(function() {
  var ctrls = angular.module('controllers');
  ctrls.controller('IndexCtrl', [
    '$scope',
    '$log',
    'DataService',
    'MyUtilService',
    IndexCtrl
  ]);

  function IndexCtrl($scope, $log, DataService, MyUtilService) {
    $log.debug('IndexCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('IndexCtrl destroy...');
    });

    DataService.send('/data/getIndexRule', {}, function(data) {
      $scope.rule = data.datas.rule;
    });

    $scope.toBiaobing = function() {
      MyUtilService.toPage('/biaobing');
    };

    $scope.toBingSao = function() {
      MyUtilService.toPage('/bingsao');
    };
  }
})();
