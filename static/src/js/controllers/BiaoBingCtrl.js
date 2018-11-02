(function() {
  var ctrls = angular.module('controllers');
  ctrls.controller('BiaoBingCtrl', ['$scope', '$log', BiaoBingCtrl]);

  function BiaoBingCtrl($scope, $log) {
    $log.debug('BiaoBingCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('BiaoBingCtrl destroy...');
    });

    $scope.voteInfo = { nums: 35, voteCount: 1923, vistors: 23412 };

    $scope.items = [
      {
        title: '某某标兵1',
        datas: [
          { name: '姓名', stars: 12345, num: '1号' },
          { name: '姓名', stars: 12345, num: '2号' },
          { name: '姓名', stars: 12345, num: '3号' }
        ]
      },
      {
        title: '某某标兵2',
        datas: [
          { name: '姓名', stars: 12345, num: '4号' },
          { name: '姓名', stars: 12345, num: '5号' },
          { name: '姓名', stars: 12345, num: '6号' }
        ]
      },
      {
        title: '某某标兵3',
        datas: [
          { name: '姓名', stars: 12345, num: '7号' },
          { name: '姓名', stars: 12345, num: '8号' },
          { name: '姓名', stars: 12345, num: '9号' }
        ]
      }
    ];
  }
})();
