(function() {
  var ctrls = angular.module('controllers');
  ctrls.controller('VoteInfoViewCtrl', [
    '$scope',
    '$log',
    'DataService',
    'MyUtilService',
    VoteInfoViewCtrl
  ]);

  function VoteInfoViewCtrl($scope, $log, DataService, MyUtilService) {
    $log.debug('VoteInfoViewCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('VoteInfoViewCtrl destroy...');
    });

    DataService.send('/data/voteInfoView', {}, function(data) {
      $scope.bblist = data.datas.bblist;
      $scope.bslist = data.datas.bslist;
    });
  }
})();
