module.exports = function(grunt) {
	
	require('load-grunt-tasks')(grunt);

	grunt.initConfig({
		pkg: grunt.file.readJSON('package.json'),
		clean: ['build'],
		copy:{
			build: {
				src: 'src/index.html', 
				dest: 'build/index.html'
			}
		},
		useminPrepare: {
			html: 'index.html',
			options: {
				dest: 'build'
			}
		},
		ngAnnotate: {
			options: {
				singleQuotes: true,
			},
			build: {
				files: {
					'build/assets/js/script.min.js': ['src/assets/js/*.js'],
				},
			},   
		},
		concat: {
			options: {
				separator: ';'
			},
			build: {
				files: {
					'build/assets/css/style.min.css': ['bower_components/bootstrap/dist/css/bootstrap.min.css', 'src/assets/css/style.css'],
					'build/assets/js/script.min.js': ['bower_components/angular/angular.min.js', 'bower_components/bootstrap/dist/js/bootstrap.min.js',
					'bower_components/angular-bootstrap/ui-bootstrap.min', 'build/assets/js/script.min.js'],
				},
			},
		},
		uglify: {
			options: {
				banner: '/*! <%= pkg.name %> <%= grunt.template.today("yyyy-mm-dd") %> */\n'
			},
			build: {
				src: ['build/assets/js/script.min.js'],
				dest: 'build/assets/js/script.min.js'
			}
		},
		cssmin: {
			build: {
				files: [{
					src: ['build/assets/css/style.min.css'],
					dest: 'build/assets/css/style.min.css',
				}]
			}
		},
		usemin:{
			build:['build/index.html']
		},
		htmlmin: {                                     
			build: {                                      
				options: {                                 
					removeComments: true,
					collapseWhitespace: true
				},
				files: {
					'build/index.html': 'build/index.html'
				}
			}
		},
		connect: {
			server: {
				options: {
					port: 9001,
					base: 'build',
					keepalive: true
				}
			}
		}
	});

	grunt.registerTask('default', ['clean', 'copy', 'useminPrepare', 'ngAnnotate', 'concat', 'uglify', 'cssmin', 'usemin', 'htmlmin',  'connect']);

};