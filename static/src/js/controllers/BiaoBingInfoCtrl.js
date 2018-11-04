(function() {
  var ctrls = angular.module('controllers');
  ctrls.controller('BiaoBingInfoCtrl', [
    '$scope',
    '$log',
    '$location',
    'DataService',
    'MyUtilService',
    BiaoBingInfoCtrl
  ]);

  function BiaoBingInfoCtrl(
    $scope,
    $log,
    $location,
    DataService,
    MyUtilService
  ) {
    $log.debug('BiaoBingInfoCtrl init...', $location.search().id);
    var bbid = $location.search().id;

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('BiaoBingInfoCtrl destroy...');
    });

    DataService.send(
      '/data/queryBiaobingById',
      { 'biaoBing.id': bbid },
      function(data) {
        $scope.biaobing = data.datas.biaobing;
      }
    );

    $scope.goback = function() {
      MyUtilService.toPage('/biaobing');
    };
  }
})();
