(function(win) {
  win.MyAppConfig = {
    name: 'myapp',
    title: '投票'
  };

  //第一个myapp的模块，引用controllers模块
  var app = angular.module(MyAppConfig.name, [
    'ngRoute',
    'ngCookies',
    'ngSanitize',
    'ngAnimate',
    'ngMessages',
    'controllers',
    'services',
    'directives'
  ]);
  // 初始化控制器，服务，指令三大模块
  angular.module('controllers', []);
  angular.module('services', []);
  angular.module('directives', []);

  //配置日志是否开启debug
  app.config([
    '$logProvider',
    function($logProvider) {
      $logProvider.debugEnabled(true);
    }
  ]);

  // 处理ajax请求
  app.config([
    '$httpProvider',
    function($httpProvider) {
      /* post提交可以使用json数据 */
      $httpProvider.defaults.headers.post['Content-Type'] =
        'application/x-www-form-urlencoded;charset=utf-8';
      var parseParams = function(params) {
        // 参数处理
        var query = '',
          name,
          value,
          fullSubName,
          subName,
          subValue,
          innerObj,
          i;
        for (name in params) {
          value = params[name];
          if (value instanceof Array) {
            for (i = 0; i < value.length; i++) {
              subValue = value[i];
              fullSubName = name + '[' + i + ']';
              innerObj = {};
              innerObj[fullSubName] = subValue;
              query += parseParams(innerObj) + '&';
            }
          } else if (value instanceof Object) {
            for (subName in value) {
              subValue = value[subName];
              fullSubName = name + '.' + subName;
              innerObj = {};
              innerObj[fullSubName] = subValue;
              query += parseParams(innerObj) + '&';
            }
          } else if (value !== undefined && value !== null) {
            query +=
              encodeURIComponent(name) + '=' + encodeURIComponent(value) + '&';
          }
        }
        var querydata = query;
        if (query.length) {
          querydata = query.substr(0, query.length - 1);
        }
        return querydata;
      };

      $httpProvider.defaults.transformRequest = [
        function(data) {
          var formdata = data;
          if (angular.isObject(data) && String(data) !== '[object File]') {
            formdata = parseParams(data);
          }
          return formdata;
        }
      ];

      /* 请求错误统一跳转到错误页面 */
      $httpProvider.interceptors.push([
        '$q',
        '$log',
        '$location',
        function($q, $log, $location) {
          return {
            responseError: function(rejection) {
              $log.debug('应答发生错误：', rejection);
              if (rejection.config.url.substr(0, 9) == 'templates') {
                $log.debug('模板页不存在==>', rejection.config.url);
                $location.path('/'); // 找不到模板转到首页，也可以跳转到统一的404错误页
              }
              return $q.reject(rejection);
            }
          };
        }
      ]);
    }
  ]);

  // 配置路由
  app.config([
    '$routeProvider',
    function($routeProvider) {
      $routeProvider
        .when('', {
          templateUrl: 'templates/index.html'
        })
        .when('/', {
          templateUrl: 'templates/index.html'
        })
        .when('/index', {
          templateUrl: 'templates/index.html'
        })
        .when('/route/:path*', {
          templateUrl: 'templates/route.html'
        })
        .otherwise({
          templateUrl: 'templates/index.html'
        });
    }
  ]);
})(window);
