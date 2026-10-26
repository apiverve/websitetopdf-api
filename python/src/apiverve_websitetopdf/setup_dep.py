from setuptools import setup, find_packages

setup(
    name='apiverve_websitetopdf',
    version='1.2.3',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Website to PDF renders any public web page into a PDF document from a submitted URL. It returns a temporary signed download link, unique filename, and expiration timestamp, with paid plans adding custom margins and landscape layout.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/websitetopdf?utm_source=pypi&utm_medium=referral&utm_content=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
