Pod::Spec.new do |s|
  s.name             = 'APIVerveWebsitetoPDF'
  s.version          = '1.2.3'
  s.summary          = 'Website to PDF renders any public web page into a PDF document from a submitted URL.'
  s.description      = <<-'DESC'
Website to PDF renders any public web page into a PDF document from a submitted URL. It returns a temporary signed download link, unique filename, and expiration timestamp, with paid plans adding custom margins and landscape layout.

This iOS/macOS SDK provides a convenient way to access the Website to PDF from APIVerve.
Supports both callback-based and async/await patterns.
                       DESC

  s.homepage         = 'https://apiverve.com/marketplace/websitetopdf?utm_source=cocoapods&utm_medium=referral&utm_content=homepage'
  s.license          = { :type => 'MIT', :file => 'LICENSE' }
  s.author           = { 'APIVerve' => 'hello@apiverve.com' }
  # The SDK repo holds every language; the pod lives under cocoapods/ with its own tag.
  s.source           = { :git => 'https://github.com/apiverve/websitetopdf-api.git', :tag => "cocoapods/v#{s.version}" }

  s.ios.deployment_target = '15.0'
  s.osx.deployment_target = '12.0'

  s.swift_version = '5.0'

  s.source_files = 'cocoapods/Sources/APIVerveWebsitetoPDF/**/*.swift'

  s.frameworks = 'Foundation'

  # APIResponse, APIVerveError and the request plumbing, shared by every APIVerve pod.
  s.dependency 'APIVerveCore', '~> 1.2'
end
