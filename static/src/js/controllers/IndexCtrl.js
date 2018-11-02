(function() {
  var ctrls = angular.module('controllers');
  ctrls.controller('IndexCtrl', ['$scope', '$log', IndexCtrl]);

  function IndexCtrl($scope, $log) {
    $log.debug('IndexCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('IndexCtrl destroy...');
    });

    $scope.voteInfo = { nums: 35, voteCount: 1923, vistors: 23412 };

    $scope.items = [
      { name: '姓名', stars: 12345, num: '一号' },
      { name: '姓名', stars: 12345, num: '一号' },
      { name: '姓名', stars: 12345, num: '一号' },
      { name: '姓名', stars: 12345, num: '一号' },
      { name: '姓名', stars: 12345, num: '一号' },
      { name: '姓名', stars: 12345, num: '一号' },
      { name: '姓名', stars: 12345, num: '一号' },
      { name: '姓名', stars: 12345, num: '一号' },
      { name: '姓名', stars: 12345, num: '一号' }
    ];
  }
})();
