(function() {
  var ctrls = angular.module('controllers');
  ctrls.controller('BingSaoCtrl', [
    '$scope',
    '$log',
    'DataService',
    'MyUtilService',
    'DialogService',
    BingSaoCtrl
  ]);

  function BingSaoCtrl(
    $scope,
    $log,
    DataService,
    MyUtilService,
    DialogService
  ) {
    $log.debug('BingSaoCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('BingSaoCtrl destroy...');
    });

    $scope.voteInfo = { nums: 35, voteCount: 1923, vistors: 23412 };

    function query() {
      DataService.send('/data/bingsaoInfos', {}, function(data) {
        $scope.items = data.datas.list;
        $scope.rule=data.datas.rule;
      });
    }

    query();

    $scope.items = [];

    $scope.info = function(id) {
      MyUtilService.toPage('/bingsaoinfo', { id: id });
    };

    $scope.goback = function() {
      MyUtilService.toPage('/index');
    };

    $scope.toVote = function() {
      var datas = $scope.items;
      var ids = [];
      for (var i = 0; i < datas.length; i++) {
        var item = datas[i];
        $log.debug(item);
        if (item.selectedId != -1) {
          ids.push(item.selectedId);
        }
      }
      if (ids.length != datas.length) {
        DialogService.showAlert(
          '必须选中' + datas.length + '个，当前选中数量为：' + ids.length
        );
        return;
      }
      $log.debug('selectIds:', ids.join(','));
      DialogService.showWait('投票中...');
      DataService.send(
        '/data/voteBiaoBing',
        { selectedIds: ids.join(',') },
        function(data) {
          DialogService.hideWait();
          DialogService.showAlert(data.message, query);
        }
      );
    };
  }
})();
