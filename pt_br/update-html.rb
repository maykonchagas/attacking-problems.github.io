require 'asciidoctor'
require 'rouge'
require_relative './default.rb'
require_relative './GoogleAnalyticsDocinfoProcessor.rb'
require_relative './autoxref-treeprocessor.rb'


def convert()
    old_verbose, $VERBOSE = $VERBOSE, true
	Asciidoctor.convert_file('index.adoc', to_file: true, header_footer: true, safe: 'safe', docinfo: 'shared-head')  

    $VERBOSE = old_verbose
end

Asciidoctor::LoggerManager.logger.level = :info
convert()
Dir.chdir('full') do
    convert()
end
