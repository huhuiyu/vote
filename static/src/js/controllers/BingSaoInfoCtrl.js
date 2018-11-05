(function() {
  var ctrls = angular.module('controllers');
  ctrls.controller('BingSaoInfoCtrl', [
    '$scope',
    '$log',
    '$location',
    'DataService',
    'MyUtilService',
    BingSaoInfoCtrl
  ]);

  function BingSaoInfoCtrl(
    $scope,
    $log,
    $location,
    DataService,
    MyUtilService
  ) {
    $log.debug('BingSaoInfoCtrl init...', $location.search().id);
    var bbid = $location.search().id;

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('BingSaoInfoCtrl destroy...');
    });

    DataService.send(
      '/data/queryBingSaoById',
      { 'biaoBing.id': bbid },
      function(data) {
        $scope.biaobing = data.datas.biaobing;
      }
    );

    $scope.goback = function() {
      MyUtilService.toPage('/bingsao');
    };
  }
})();
